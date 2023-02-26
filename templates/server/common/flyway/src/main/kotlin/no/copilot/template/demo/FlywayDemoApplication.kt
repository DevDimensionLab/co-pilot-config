package no.copilot.template.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlywayDemoApplication

fun main(args: Array<String>) {
	runApplication<FlywayDemoApplication>(*args)
}
