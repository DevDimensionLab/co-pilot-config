package org.devdimensionlab.templates.client

import no.copilot.templates.api.Team
import no.copilot.templates.api.TeamService

class TeamServiceHttpClient : TeamService {

    override fun getByName(name: String): Team {
        return Team(name)
    }

}