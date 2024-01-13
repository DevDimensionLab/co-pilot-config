package io.plybuild.test.templates

import java.io.File

data class TemplateFile(val file : File) {
    val name : String = file.name
    val code : String = file.readText()

    override fun toString(): String {
        return name
    }


}
