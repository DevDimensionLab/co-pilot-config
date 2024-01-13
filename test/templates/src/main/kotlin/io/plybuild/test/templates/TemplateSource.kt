package io.plybuild.test.templates

class TemplateSource( val templateDir : TemplateDir) {

    override fun toString(): String {
        return templateDir.toString()
    }

    fun getPly(): Ply = templateDir.getPly()

    fun getSourceCode() : List<TemplateFile> = templateDir.getSourceCode()
}