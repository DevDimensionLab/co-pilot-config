package no.co_pilot_cli.template.client.config

import no.co_pilot_cli.template.client.*
import no.co_pilot_cli.template.client.domain.Foo

class FooHttpClient(private val config: RequestConfig) {

    fun getFooByName(name : String) : Foo = exchange(getRequestForFoo(name, config)).toFoo()

    fun postFooByName(name : String, foo: Foo) : Foo = exchange(postRequestForFoo(name, foo.fromFoo(), config)).toFoo()

    private fun String.toFoo(): Foo {
        return mapper.readValue(this, Foo::class.java)
    }

    private fun Foo.fromFoo() : String {
        return mapper.writeValueAsString(this);
    }
}