package no.co_pilot_cli.template.scheduling

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.ErrorHandler

@Component
class TaskErrorHandler : ErrorHandler {

    private val log = LoggerFactory.getLogger(TaskErrorHandler::class.java)

    override fun handleError(error: Throwable) {
        log.error("Error in task: ${error.message}",error)
    }
}