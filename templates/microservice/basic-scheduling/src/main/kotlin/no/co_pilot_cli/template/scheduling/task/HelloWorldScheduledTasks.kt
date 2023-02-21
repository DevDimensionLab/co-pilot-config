package no.co_pilot_cli.template.scheduling.task

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class HelloWorldScheduledTasks  {
    companion object {
        private val log = LoggerFactory.getLogger(HelloWorldScheduledTasks::class.java)
    }

    @Scheduled(fixedDelay = 3000)
    fun process() {
           log.info("Hello World!" )
    }
}