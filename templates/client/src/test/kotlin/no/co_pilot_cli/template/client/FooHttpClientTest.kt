package no.co_pilot_cli.template.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import no.co_pilot_cli.template.client.config.HttpClientException
import no.co_pilot_cli.template.client.config.RequestConfig
import no.co_pilot_cli.template.client.config.mapper
import no.co_pilot_cli.template.client.domain.Foo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FooHttpClientTest {
    private val wiremock: WireMockServer = WireMockServer(WireMockConfiguration.options()
            .dynamicPort()
            .notifier(ConsoleNotifier(true)))

    @Test
    fun getFooByNameNotFound() {
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

    @Test
    internal fun postRequestForFoo() {
        val requestConfig = RequestConfig(url = "http://localhost", port = wiremock.port())
        val fooClient = FooHttpClient(config = requestConfig)
        val result = fooClient.postFooByName("bar", Foo("bar"))

        assertNotNull(result)
        assertEquals("bar", result.name)
        wiremock.verify(1, postRequestedFor(urlEqualTo("/api/foo?name=bar")))
    }

    @BeforeEach
    internal fun setUp() {
        wiremock.start()
        wiremock.stubFor(get(urlEqualTo("/api/foo?name=bar"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(jacksonObjectMapper().writeValueAsString(Foo("bar")))))

        wiremock.stubFor(post(urlEqualTo("/api/foo?name=bar"))
                .withRequestBody(equalToJson(mapper.writeValueAsString(Foo("bar"))))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(jacksonObjectMapper().writeValueAsString(Foo("bar")))))
    }

    @AfterEach
    internal fun tearDown() {
        wiremock.stop()

    }
}