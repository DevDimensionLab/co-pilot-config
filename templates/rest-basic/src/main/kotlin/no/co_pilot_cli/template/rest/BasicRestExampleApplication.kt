package no.co_pilot_cli.template.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicRestExampleApplication

fun main(args: Array<String>) {
	runApplication<BasicRestExampleApplication>(*args)
}
