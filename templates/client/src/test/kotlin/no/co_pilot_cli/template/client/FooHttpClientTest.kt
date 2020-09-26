package no.co_pilot_cli.template.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FooHttpClientTest {
    private val wiremock: WireMockServer = WireMockServer(WireMockConfiguration.options()
            .dynamicPort()
            .notifier(ConsoleNotifier(true)))

    @Test
    fun getFooByNameBadRequest() {
        val requestConfig = RequestConfig(url = "http://localhost", port = wiremock.port())
        val fooClient = FooHttpClient(config = requestConfig)

        val exception = assertThrows(HttpClientException::class.java) { fooClient.getFooByName("") }
        assertEquals(404, exception.status)
    }

    @Test
    fun getFooByName() {
        val requestConfig = RequestConfig(url = "http://localhost", port = wiremock.port())
        val fooClient = FooHttpClient(config = requestConfig)
        val result = fooClient.getFooByName("bar")

        assertNotNull(result)
        assertEquals("bar", result.name)
        wiremock.verify(1, getRequestedFor(urlEqualTo("/api/foo?name=bar")))
    }

    @BeforeEach
    internal fun setUp() {
        wiremock.start()
        wiremock.stubFor(get(urlEqualTo("/api/foo?name=bar"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(jacksonObjectMapper().writeValueAsString(Foo("bar")))))

    }

    @AfterEach
    internal fun tearDown() {
        wiremock.stop()

    }
}