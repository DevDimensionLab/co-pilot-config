package io.plybuild.templates.client.http

class HttpException(
    message: String?,
    cause: Throwable? = null,
    val problem: ProblemDetail?
) : RuntimeException(message, cause) {

    constructor(message: String, cause: Throwable) : this(
        message = message,
        cause = cause,
        problem = null
    )

    constructor(problem: ProblemDetail) : this(
        message = problem.title + " - " + problem.detail,
        cause = null,
        problem = problem
    )

}
