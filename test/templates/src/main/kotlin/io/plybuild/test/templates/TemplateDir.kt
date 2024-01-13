package io.plybuild.test.templates

import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File

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

    fun getPly(): Ply = mapper.readValue(
        templateRootFiles.first { it.name == "ply.json" }.file,
        Ply::class.java)

    fun getSourceCode(): List<TemplateFile> =
        dir.listFiles().firstOrNull { it.name == "src" }
            ?.let { getSourceCode( it.listFiles()) }
            ?: listOf()

    private fun getSourceCode(files: Array<File>) : List<TemplateFile> =
        (files
            .filter { it.isFile }
            .map { TemplateFile(it) }
                +
                files
                    .filter { it.isDirectory }
                    .flatMap { getSourceCode(it.listFiles()) })

}