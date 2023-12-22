package org.devdimensionlab.templates.client.http

class HttpRestResponse<T>(val status : Int, val bodyFunc: () -> T) {
    fun body() : T {
        return bodyFunc.invoke()
    }

}