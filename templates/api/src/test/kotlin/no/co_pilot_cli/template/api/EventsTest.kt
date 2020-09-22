package no.co_pilot_cli.template.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

internal class EventsTest {

    @Test
    fun getResult() {

        val objectMapper = ObjectMapper()
        objectMapper.registerModule(KotlinModule())
        objectMapper.registerModule(JavaTimeModule())

        val events = Events(42, 12, listOf(
                Event(42, EventType.CREATE, UUID.randomUUID().toString(), timestamp = LocalDateTime.now()),
                Event(42, EventType.CREATE, UUID.randomUUID().toString(), timestamp = LocalDateTime.now())))


        val json = objectMapper.writeValueAsString(events)

        val eventsFromJson = objectMapper.readValue(json, Events::class.java)

        assertEquals( events, eventsFromJson )
    }
}