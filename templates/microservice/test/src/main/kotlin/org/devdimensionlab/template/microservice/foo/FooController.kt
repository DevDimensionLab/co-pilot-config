package org.devdimensionlab.template.microservice.foo

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