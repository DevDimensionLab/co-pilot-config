package no.co_pilot_cli.template.rest.service

import no.co_pilot_cli.template.rest.domain.Foo
import org.springframework.stereotype.Service

@Service
class FooService {
    fun getAll(): List<Foo> {
        return listOf()
    }
}