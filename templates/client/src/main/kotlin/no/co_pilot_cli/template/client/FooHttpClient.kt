package no.co_pilot_cli.template.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

class FooHttpClient(private val config: RequestConfig) {

    fun getFooByName(name : String) : Foo = exchange(getRequestForFoo(name, config)).toFoo()

    private val mapper: ObjectMapper = ObjectMapper()
            .registerModule(KotlinModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

    private fun String.toFoo(): Foo {
        return mapper.readValue(this, Foo::class.java)
    }
}