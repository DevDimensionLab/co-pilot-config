package no.co_pilot_cli.template.api

data class Events (val fromSequence: Long, val chunk : Int, val result : List<Event>)