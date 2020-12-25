package commands

import java.io.File

class CreateDirectoryCommand(
    private val path: String
) : Command {
    override fun execute() {
        File(path).mkdirs()
    }
}