package org.devdimensionlab.template.http.rest.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HttpRestClientApplication

fun main(args: Array<String>) {
	runApplication<HttpRestClientApplication>(*args)
}
