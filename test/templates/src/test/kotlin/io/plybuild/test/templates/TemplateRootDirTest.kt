package io.plybuild.test.templates

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class TemplateRootDirTest {

    val templatesRoot = TemplateRootDir(File("../../templates"))

    @Test
    fun test() {
        val templateSources : List<TemplateSource>  = templatesRoot.getTemplateSources()

        templateSources.forEach {
            val ply = it.getPly()
            println( "verify ${it.templateDir.dir.name} -> package: ${ply._package}")
            println( "source files: " + it.getSourceCode() )
            it.getSourceCode().forEach { source ->
                if(source.name.endsWith( ".kt")) {
                    println( source )

                    assertTrue(
                        source.code.contains("package ${ply._package}")
                    ) { "${source.file} does not contain package ${ply._package} defined in ply.json" }

                }
            }
        }
    }
}