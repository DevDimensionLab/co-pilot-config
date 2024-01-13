package io.plybuild.test.templates

import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.lang.AssertionError

data class TemplateDir(
    val dir: File,
    val templateRootFiles: List<TemplateFile>,
    val directories: List<TemplateDir>)
{
    private val mapper: ObjectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
        .registerKotlinModule()
        .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    fun isTemplateSource() = templateRootFiles.any { it.name == "ply.json" }

    fun getPly(): Ply {
        val plyJson = templateRootFiles.first { it.name == "ply.json" }.file
        try {
            return mapper.readValue(plyJson, Ply::class.java)
        } catch (e : Exception) {
            throw AssertionError("Error reading $plyJson: $e",e)
        }
    }

    fun getSourceCode(): List<TemplateFile> =
        dir.listFiles().firstOrNull { it.name == "src" }
            ?.let { getSourceCode( it.listFiles()) }
            ?: getSourceCode(dir.listFiles())

    private fun getSourceCode(files: Array<File>) : List<TemplateFile> =
        (files
            .filter { it.isFile }
            .map { TemplateFile(it) }
                +
                files
                    .filter { it.isDirectory }
                    .filter { it.name != "target" }
                    .flatMap { getSourceCode(it.listFiles()) })

}