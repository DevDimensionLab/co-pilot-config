package org.devdimensionlab.templates.client.http

import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.http.HttpResponse

data class ProblemDetail(
    val type: String,
    val title: String,
    val status: Int,
    val detail: String,
    val instance: String
)

class TypedResponse<T> private constructor(
    val status: Int,
    private val bodyFunc: (() -> T),
    val problem: ProblemDetail?
) {
    fun body(): T {
        problem?.let {
            throw HttpException(
                message = problem.title + " - " + problem.detail,
                problem = problem
            )
        }
        return bodyFunc.invoke()
    }

    companion object {
        fun <T> create(
            objectMapper: ObjectMapper,
            httpResponse: HttpResponse<String>,
            responseType: JavaType
        ): TypedResponse<T> {
            val httpResponseIsProblemJson =
                httpResponse.headers().map()["content-type"]?.contains("application/problem+json") == true
            return TypedResponse(
                status = httpResponse.statusCode(),
                bodyFunc = { objectMapper.readValue(httpResponse.body(), responseType) },
                problem =
                if (httpResponseIsProblemJson)
                    objectMapper.readValue(httpResponse.body(), ProblemDetail::class.java)
                else
                    null
            )
        }
    }
}