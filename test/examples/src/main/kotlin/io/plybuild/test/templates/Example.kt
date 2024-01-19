package io.plybuild.test.templates

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

class Example(val dir : File) {

    private val mapper: ObjectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
        .registerKotlinModule()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    val name = dir.name
    val ply : Ply = dir.listFiles().first { it.name == "ply.json" }
        .let { mapper.readValue(it.readBytes(), Ply::class.java) }
}