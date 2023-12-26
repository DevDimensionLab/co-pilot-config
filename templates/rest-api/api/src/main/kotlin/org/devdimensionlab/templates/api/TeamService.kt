package no.copilot.templates.api

import org.devdimensionlab.templates.api.Team

interface TeamService {

    fun getAll(): List<Team>

    fun getByName(name : String) : Team

}