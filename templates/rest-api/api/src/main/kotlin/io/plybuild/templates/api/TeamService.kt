package io.plybuild.templates.api

interface TeamService {

    fun getAll(): List<Team>

    fun getAllAsMap(): Map<String, Team>

    fun getByName(name : String) : Team

}