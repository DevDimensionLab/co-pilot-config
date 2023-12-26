package org.devdimensionlab.templates.client.http

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.System.currentTimeMillis
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpClient.Version.HTTP_1_1
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets.UTF_8
import java.time.Duration


open class HttpRestClient(
    private val baseUrl: String,
    private val timeout: Duration = Duration.ofSeconds(15),
    private val httpClient: HttpClient = HttpClient.newBuilder().version(HTTP_1_1).build(),
    private val objectMapper: ObjectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
        .registerKotlinModule())
{
    private val log: Logger = LoggerFactory.getLogger(HttpRestClient::class.java)

    fun <T> getEntity(path: String, responseType: Class<T>): TypedResponse<T>
        = getEntity(path, objectMapper.typeFactory.constructType(responseType))
    fun <T> getEntity(path: String, responseType: TypeReference<T>): TypedResponse<T>
        = getEntity(path, objectMapper.typeFactory.constructType(responseType))
    fun <T> getEntities(path: String, responseType: Class<T>): TypedResponse<List<T>>
        = getEntity(path, objectMapper.typeFactory.constructCollectionType(List::class.java, responseType))

    private fun <T> getEntity(path: String, responseType: JavaType): TypedResponse<T> {

        val uri = URI(baseUrl + path)
        val httpRequest: HttpRequest = HttpRequest.newBuilder()
            .uri(uri)
            .timeout(timeout)
            .GET()
            .build()

        val start = currentTimeMillis()
        val response: Result<HttpResponse<String>> = httpClient.runCatching {
            send(httpRequest) { HttpResponse.BodySubscribers.ofString(UTF_8) }
        }
        val elapsedTime = currentTimeMillis().minus(start)

        return response.fold(
            onSuccess = {
                log.info("$uri ${it.statusCode()} ${elapsedTime}ms ")

                if (it.headers().map()["content-type"]?.contains("application/problem+json") == true)
                    TypedResponse(problem = objectMapper.readValue(it.body(), ProblemDetail::class.java))
                else
                    TypedResponse(
                        status = it.statusCode(),
                        bodyFunc = { objectMapper.readValue(it.body(), responseType) })
            },
            onFailure = {
                throw HttpRestException(
                    message = "$uri ${elapsedTime}ms - $it",
                    cause = it
                )
            }
        )
    }
}

