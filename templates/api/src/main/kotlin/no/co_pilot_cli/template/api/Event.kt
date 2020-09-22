package no.co_pilot_cli.template.api

import java.time.LocalDateTime

data class Event (val sequenceNumber: Long, val eventType: EventType, val eventDocument : String, val timestamp : LocalDateTime )