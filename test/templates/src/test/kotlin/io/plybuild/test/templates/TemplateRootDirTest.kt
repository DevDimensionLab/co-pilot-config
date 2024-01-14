package io.plybuild.test.templates

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class TemplateRootDirTest {

    val templatesRoot = TemplateRootDir(File("../../templates"))
    val templateSources : List<TemplateSource>  = templatesRoot.getTemplateSources()

    @Test
    fun `package defined in ply_json should be consitens with kotlin source files`() {
        templateSources.forEach {
            it.getSourceCode().forEach { source ->
                if(source.name.endsWith( ".kt")) {
                    assertTrue(source.code.contains("package ${it.getPly()._package}"))
                        { "${source.file} does not contain package ${it.getPly()._package} defined in ply.json" }
                }
            }
        }
    }

    @Test
    fun `template source should no contain co-pilot`() {
        templateSources.forEach {
            it.getSourceCode().forEach { source ->
                    assertFalse(source.code.contains("co-pilot"))
                    { "${source.file} should not contain co-pilot" }
                }
            }
    }
}