package org.devdimensionlab.templates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiClientApplication

fun main(args: Array<String>) {
	runApplication<ApiClientApplication>(*args)
}
