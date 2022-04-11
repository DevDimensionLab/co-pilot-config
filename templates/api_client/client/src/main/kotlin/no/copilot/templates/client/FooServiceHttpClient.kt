package no.copilot.templates.client

import no.copilot.templates.api.Foo
import no.copilot.templates.api.FooService

class FooServiceHttpClient : FooService {

    override fun findFooBy(name: String): Foo? {
        return null
    }

}