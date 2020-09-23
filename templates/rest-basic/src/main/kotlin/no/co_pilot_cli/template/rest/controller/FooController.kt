package no.co_pilot_cli.template.rest.controller

import no.co_pilot_cli.template.rest.domain.Foo
import no.co_pilot_cli.template.rest.service.FooService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/foo")
class FooController(private val fooService: FooService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Foo>> {
        return ResponseEntity.ok(fooService.getAll())
    }
}