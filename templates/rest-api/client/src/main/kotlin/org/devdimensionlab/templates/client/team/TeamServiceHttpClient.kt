package org.devdimensionlab.templates.client.team

import com.fasterxml.jackson.core.type.TypeReference
import org.devdimensionlab.templates.api.Team
import org.devdimensionlab.templates.api.TeamService
import org.devdimensionlab.templates.client.http.HttpRestClient

class TeamServiceHttpClient(private val httpClient: HttpRestClient) : TeamService {
    override fun getAll(): List<Team> =
        httpClient.getEntities("/teams", Team::class.java).body()

    override fun getAllAsMap(): Map<String, Team> =
        httpClient.getEntity("/teams/keyvalue", object : TypeReference<Map<String, Team>>() {}).body()

    override fun getByName(name: String): Team =
        httpClient.getEntity("/teams/$name", Team::class.java).body()

}