package io.plybuild.templates.scheduling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicSchedulingExampleApplication

fun main(args: Array<String>) {
	runApplication<BasicSchedulingExampleApplication>(*args)
}
