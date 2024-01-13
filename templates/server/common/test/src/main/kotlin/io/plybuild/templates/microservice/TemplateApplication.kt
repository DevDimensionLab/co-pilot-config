package io.plybuild.templates.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TemplateTestApplication

fun main(args: Array<String>) {
	runApplication<TemplateTestApplication>(*args)
}
