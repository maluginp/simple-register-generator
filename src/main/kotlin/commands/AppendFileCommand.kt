package commands

import java.io.File

class AppendFileCommand(
    private val path: String,
    private val line: String
) : Command {
    override fun execute() {
        File(path).appendText(line)
    }
}