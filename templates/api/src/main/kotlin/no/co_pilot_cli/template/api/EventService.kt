package no.co_pilot_cli.template.api

interface EventService {
    fun getEvents( fromSequence: Long, chunk : Int) : Events
}