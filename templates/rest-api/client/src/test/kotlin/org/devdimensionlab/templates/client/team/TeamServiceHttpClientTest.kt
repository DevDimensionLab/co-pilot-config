package org.devdimensionlab.templates.client.team

import org.devdimensionlab.templates.client.conf.RestApiApplication
import org.devdimensionlab.templates.client.http.testapp.HttpRestClientApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(classes = [HttpRestClientApplication::class], webEnvironment = RANDOM_PORT)
class TeamServiceHttpClientTest {

    @LocalServerPort
    var serverPort : Int = 0

    lateinit var teamService : TeamServiceHttpClient

    @BeforeEach
    fun setup() {
        teamService = TeamServiceHttpClient(RestApiApplication("http://localhost:$serverPort"))
    }

    @Test
    fun `Get all teams`() {
        assertEquals(3, teamService.getAll().size )
    }

    @Test
    fun `Get all teams ny id and Team`() {
        assertEquals(3, teamService.getAllAsMap().size )
    }

    @Test
    fun `Get team by id`() {
        assertEquals("blue", teamService.getByName("blue").name)
    }

}