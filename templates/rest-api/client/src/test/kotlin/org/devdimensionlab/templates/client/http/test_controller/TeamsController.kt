package org.devdimensionlab.templates.client.http.test_controller

import org.devdimensionlab.templates.api.Team
import no.copilot.templates.api.TeamService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/teams"])
class TeamsController : TeamService {

    @GetMapping
    override fun getAll(): List<Team> = listOf( Team("green"), Team("yellow"), Team("red") )

    @GetMapping("/{name}")
    override fun getByName(@PathVariable("name") name: String): Team = Team(name)

}