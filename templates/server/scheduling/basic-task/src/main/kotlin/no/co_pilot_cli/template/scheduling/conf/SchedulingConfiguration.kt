package no.co_pilot_cli.template.scheduling.conf


import no.co_pilot_cli.template.scheduling.TaskErrorHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.task.TaskSchedulerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@ConditionalOnProperty(value = ["app.scheduling.enabled"], havingValue = "true" )
@Configuration
@EnableScheduling
class SchedulingConfiguration {

    @Bean
    fun taskSchedulerCustomizer(errorHandler : TaskErrorHandler) : TaskSchedulerCustomizer
            = TaskSchedulerCustomizer { it.setErrorHandler(errorHandler) }
}