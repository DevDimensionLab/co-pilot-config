package io.plybuild.test.templates

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class ExamplesDirTest {

    val targetDir = File("./target")

    val examplesRoot = ExamplesRootDir(File("../../examples"))

    @BeforeEach
    fun setup() {
        targetDir.mkdir()
    }

    @Test
    fun `each example should contain a ply dot json`() {
        examplesRoot.examples.forEach { println( it.name) }
    }

    @Test
    fun `run one example`() {
        testExample("rest-api", targetDir)
    }

    @Test
    fun `run all examples`() {
        examplesRoot.examples.forEach {
            println( "TEST --> " + it.name)
            testExample("rest-api", targetDir)
        }
    }

    private fun testExample(example: String, file: File) {
        val plyBuild = plyBuildProcess(example)
        val plyEitCode = execute(plyBuild, file)

        assertEquals(0, plyEitCode)

        val mvnCleanInstall = mvnCleanInstallProcess(example)
        val mvnExitCode = execute(mvnCleanInstall, File(file, example))
        assertEquals(0, mvnExitCode)
    }

    private fun plyBuildProcess(example: String): ProcessBuilder {
            val processBuilder = ProcessBuilder(
            "ply", "build",
            "example", "--name", example,
            "--target", example,
            "--force"
        )
        return processBuilder
    }

    private fun mvnCleanInstallProcess(example: String): ProcessBuilder {
        return ProcessBuilder("mvn", "clean", "install")
    }

    private fun execute(processBuilder: ProcessBuilder, file: File): Int {
        processBuilder.directory(file)
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)
        val process = processBuilder.start()
        val exitCode = process.waitFor()
        println("Exited with code $exitCode")
        return exitCode
    }


}