package org.devdimensionlab.templates.client.http

data class ProblemDetail(
    val type: String,
    val title: String,
    val status: Int,
    val detail: String,
    val instance: String
)

class TypedResponse<T> private constructor(
    val status: Int,
    val bodyFunc: (() -> T)?,
    val problem: ProblemDetail?)
{
    constructor(status: Int, bodyFunc: (() -> T)? = null) : this(
        status = status,
        bodyFunc = bodyFunc,
        problem = null)
    constructor(problem: ProblemDetail) : this(
        status = problem.status,
        bodyFunc = null,
        problem = problem)

    fun body(): T {
        problem?.let {
            throw HttpRestException(
                message = problem.title + " - " + problem.detail ,
                problem = problem
            )
        }
        return bodyFunc?.invoke()!!
    }
}