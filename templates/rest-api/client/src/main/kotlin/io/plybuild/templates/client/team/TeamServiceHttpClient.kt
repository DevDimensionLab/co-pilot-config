package io.plybuild.templates.client.team

import com.fasterxml.jackson.core.type.TypeReference
import io.plybuild.templates.api.Team
import io.plybuild.templates.api.TeamService
import io.plybuild.templates.client.conf.RestApiHttpClient

class TeamServiceHttpClient(private val httpClient: RestApiHttpClient) : TeamService {
    override fun getAll(): List<Team> =
        httpClient.getEntities("/teams", Team::class.java).body()

    override fun getAllAsMap(): Map<String, Team> =
        httpClient.getEntity("/teams/keyvalue", object : TypeReference<Map<String, Team>>() {}).body()

    override fun getByName(name: String): Team =
        httpClient.getEntity("/teams/$name", Team::class.java).body()

}