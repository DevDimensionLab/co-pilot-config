package org.devdimensionlab.templates.client.http

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * The render-version of this file will make sure it makes it into generated code.
 * @SpringBootApplication are removed by default.
 */
@SpringBootApplication
open class HttpRestClientApplication

fun main(args: Array<String>) {
	runApplication<HttpRestClientApplication>(*args)
}