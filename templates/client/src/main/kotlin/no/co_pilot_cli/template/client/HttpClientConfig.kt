package no.co_pilot_cli.template.client

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandler
import java.nio.charset.StandardCharsets

val httpClient: HttpClient = HttpClient.newHttpClient();
val responseBodyHandler = BodyHandler { HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8) }

class HttpClientException(val status: Int, val body: String) : RuntimeException()
class HttpServerException(val status: Int, val body: String) : RuntimeException()

data class RequestConfig(val url : String, val port : Int)

fun getRequestForFoo(name: String, config: RequestConfig): HttpRequest =
        HttpRequest.newBuilder(URI("${config.url}:${config.port}/api/foo?name=${name}"))
                .setHeader("Content-Type", "application/json")
                .GET().build()

fun exchange(request: HttpRequest): String {
    val response = httpClient.send(request, responseBodyHandler)
    return when (response.statusCode()) {
        in 200..399 -> response.body()
        in 400..499 -> throw HttpClientException(response.statusCode(), response.body())
        else -> throw HttpServerException(response.statusCode(), response.body())
    }
}

