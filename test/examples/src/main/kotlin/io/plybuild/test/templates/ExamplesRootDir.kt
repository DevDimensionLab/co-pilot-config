package io.plybuild.test.templates

import java.io.File

class ExamplesRootDir(templateDir: File) {

    val examples : List<Example> =
        templateDir.listFiles()
            .filter { it.isDirectory }
            .map { Example(it) }


}