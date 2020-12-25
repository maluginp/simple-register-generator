package commands

import java.io.File

class CopyTemplatedFileCommand(
    private val inputFile: File,
    private val outputFile: File,
    private val variables: HashMap<String, String> = hashMapOf()
): Command {

    constructor(inputPath: String, outputPath: String, variables: HashMap<String, String>)
        : this(File(inputPath), File(outputPath), variables)

    override fun execute() {
        var template = inputFile.readText()

        for (variable in variables.entries) {
            template = template.replace("\${${variable.key}}", variable.value)
        }

        outputFile.writeText(template)
    }
}