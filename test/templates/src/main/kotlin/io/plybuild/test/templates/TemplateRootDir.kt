package io.plybuild.test.templates

import java.io.File

class TemplateRootDir(templateDir: File) {

    private val directories : List<TemplateDir> =
        templateDir.listFiles()
            .filter { it.isDirectory }
            .map { templateDir(it, it.listFiles()) }

    private fun templateDir(dir : File, files: Array<File> ) =
        TemplateDir(
            dir = dir,
            templateRootFiles = files
                .filter { it.isFile }
                .map { TemplateFile(file = it) },
            directories = files
                .filter { it.isDirectory && !it.name.equals("target")}
                .map { listTemplateDirRecursively(it) })

    fun getTemplateSources() : List<TemplateSource> = getTemplateSources(directories)

    private fun getTemplateSources(subdirectories:List<TemplateDir>) : List<TemplateSource> =
        (subdirectories
            .filter { it.isTemplateSource() }
            .map { TemplateSource(it) }
                +
                subdirectories
                    .filter { !it.isTemplateSource() }
                    .flatMap { getTemplateSources(it.directories) })

    private fun listTemplateDirRecursively(dir: File): TemplateDir = templateDir(dir, dir.listFiles())
}