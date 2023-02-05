package org.devdimensionlab.template.microservice.foo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FooControllerTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    private var port = 0

    @Test
    @Throws(Exception::class)
    fun getAllFooShouldContainEmptyList() {
        assertThat(restTemplate.getForObject("http://localhost:$port/api/foo", String::class.java)).contains("[]")
    }
}