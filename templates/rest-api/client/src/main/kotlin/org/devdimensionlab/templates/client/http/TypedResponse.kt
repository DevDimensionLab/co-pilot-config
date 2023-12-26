package org.devdimensionlab.templates.client.http

class TypedResponse<T>(val status : Int, val bodyFunc: () -> T) {
    fun body() : T {
        return bodyFunc.invoke()
    }

}