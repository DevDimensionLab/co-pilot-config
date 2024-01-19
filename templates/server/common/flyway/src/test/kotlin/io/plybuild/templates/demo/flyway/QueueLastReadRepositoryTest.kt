package io.plybuild.templates.demo.flyway

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestPropertySource

@DataJpaTest
@TestPropertySource(properties = ["spring.config.location=classpath:application-data-jpa-test.properties"])
class QueueLastReadRepositoryTest()  {

    @Autowired
    lateinit var  queueLastReadRepository: QueueLastReadRepository

    @Test
    fun `Read last value for the bar queue`() {
        assertTrue(queueLastReadRepository.findById(Queue.BAR).isPresent)
    }
}