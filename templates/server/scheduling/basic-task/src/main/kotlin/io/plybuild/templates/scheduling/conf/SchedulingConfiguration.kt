package io.plybuild.templates.scheduling.conf


import io.plybuild.templates.scheduling.TaskErrorHandler
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