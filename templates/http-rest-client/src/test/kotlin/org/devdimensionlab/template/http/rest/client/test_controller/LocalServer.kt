package org.devdimensionlab.template.microservice

import org.devdimensionlab.template.http.rest.client.HttpRestClientApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Configuration

@Import(HttpRestClientApplication::class)
@Configuration
open class LocalServer {
}

fun main(args: Array<String>) {
    runApplication<LocalServer>(*args)
}