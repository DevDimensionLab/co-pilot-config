package no.copilot.templates.api

interface TeamService {

    fun getByName(name : String) : Team

}