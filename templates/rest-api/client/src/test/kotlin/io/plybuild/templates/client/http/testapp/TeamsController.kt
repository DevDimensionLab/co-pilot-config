package io.plybuild.templates.client.http.testapp

import io.plybuild.templates.api.Team
import io.plybuild.templates.api.TeamService
import org.springframework.http.HttpStatusCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.lang.IllegalArgumentException

@RestController
@RequestMapping(value = ["/resource/teams"])
class TeamsController : TeamService {

    @GetMapping
    override fun getAll(): List<Team> = listOf(Team("green"), Team("yellow"), Team("red"))

    @GetMapping("/keyvalue")
    override fun getAllAsMap(): Map<String, Team> = mapOf(
        "green" to Team("green"),
        "yellow" to Team("yellow"),
        "red" to Team("red")
    )
    @GetMapping("/{name}")
    override fun getByName(@PathVariable("name") name: String): Team = Team(name)

    @GetMapping("/exception")
    fun exception() : Team = throw IllegalArgumentException( "IllegalArgumentException")

    @GetMapping("/exception2")
    fun exception2() : Team = throw ResponseStatusException(HttpStatusCode.valueOf(500),  "simulated internal error")

}