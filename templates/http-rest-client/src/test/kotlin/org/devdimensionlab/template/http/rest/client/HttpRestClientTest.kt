package org.devdimensionlab.template.http.rest.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.devdimensionlab.template.http.rest.client.test_controller.Customer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRestClientTest {

	@LocalServerPort
	var serverPort : Int = 0

	@Test
	fun `Get entity`() {
		val restClient = HttpRestClient(
			baseUrl = "http://localhost:$serverPort",
			objectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build()))

		val response = restClient.getEntity("/customers/42", Customer::class.java)

		assertEquals( 200, response.status)
		assertEquals("42", response.body().customerId )
	}

}
