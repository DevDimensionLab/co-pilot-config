package no.co_pilot_cli.template.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiTemplateApplication

fun main(args: Array<String>) {
	runApplication<ApiTemplateApplication>(*args)
}
