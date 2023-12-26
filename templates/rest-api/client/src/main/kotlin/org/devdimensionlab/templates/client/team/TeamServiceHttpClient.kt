package org.devdimensionlab.templates.client.team

import org.devdimensionlab.templates.api.Team
import no.copilot.templates.api.TeamService
import org.devdimensionlab.templates.client.http.HttpRestClient

class TeamServiceHttpClient(private val httpClient: HttpRestClient) : TeamService {
    override fun getAll(): List<Team> =
        httpClient.getEntities("/teams", Team::class.java).body()

    override fun getByName(name: String): Team =
        httpClient.getEntity("/teams/red", Team::class.java).body()

}