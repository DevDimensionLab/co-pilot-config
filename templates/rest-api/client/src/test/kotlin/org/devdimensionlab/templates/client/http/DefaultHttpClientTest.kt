package org.devdimensionlab.templates.client.http

import com.fasterxml.jackson.core.type.TypeReference
import org.devdimensionlab.templates.api.Team
import org.devdimensionlab.templates.client.http.testapp.HttpRestClientApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort


@SpringBootTest(classes = [HttpRestClientApplication::class], webEnvironment = RANDOM_PORT)
class DefaultHttpClientTest {

	@LocalServerPort
	var serverPort : Int = 0

	private lateinit var restClient: DefaultHttpClient

	@BeforeEach
	fun setup() {
		this.restClient = DefaultHttpClient(baseUrl = "http://localhost:$serverPort/resource")
	}

	@Test
	fun `Get entity should return response status 200 for ok`() {
		val response = restClient.getEntity("/teams/red", Team::class.java)
		assertEquals( 200, response.status)
	}

	@Test
	fun `Get entity should support simple type for body `() {
		val response = restClient.getEntity("/teams/red", Team::class.java)
		assertEquals("red", response.body().name )
	}

	@Test
	fun `Get entity should support map as type for body`() {
		val response = restClient.getEntity("/teams/keyvalue", object : TypeReference<Map<String, Team>>() {})
		assertEquals(3, response.body().size )
	}

	@Test
	fun `Get entities should return list response for body `() {
		val response = restClient.getEntities("/teams", Team::class.java)
		assertEquals(3, response.body().size )
	}

	// error handling below -->

	@Test
	fun `Get entity should return response status 404 for not found`() {
		val response = restClient.getEntity("/xyz/red", Team::class.java)
		assertEquals( 404, response.status)
	}

	@Test
	fun `Rest client should throw HttpRestExeption with ConnectException as cause for unknow host`() {
		this.restClient = DefaultHttpClient(baseUrl = "http://unknowhost")

		val httpRestException: HttpRestException = assertThrows(
			HttpRestException::class.java) {
			restClient.getEntity("/xyz/red", Team::class.java)
		}

		assertEquals(java.net.ConnectException::class.java, httpRestException.cause?.javaClass )
	}

	@Test
	fun `calling body on a result with a problem should result in an http-exception`() {

		val httpRestException: HttpRestException = assertThrows(
			HttpRestException::class.java) {
			restClient.getEntity("/teams/exception", Team::class.java).body()
		}

	 	assertEquals("Internal Server Error", httpRestException.problem?.title )
		assertEquals("IllegalArgumentException", httpRestException.problem?.detail )
	}


}
