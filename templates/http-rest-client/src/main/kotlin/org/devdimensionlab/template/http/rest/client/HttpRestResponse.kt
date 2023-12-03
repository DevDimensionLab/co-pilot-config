package org.devdimensionlab.template.http.rest.client

class HttpRestResponse<T>(val status : Int, val bodyFunc: () -> T) {
    fun body() : T {
        return bodyFunc.invoke()
    }

}