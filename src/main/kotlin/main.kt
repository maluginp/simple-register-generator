import templates.FeatureTemplate
import java.io.File

fun main(args: Array<String>) {

    val featurePackageName = "ru.malpen.simpleregister.features"
    val rootPackageName = "ru.malpen.simpleregister"

    val workingPath = System.getProperty("user.dir")

    val targetPath = "$workingPath/test"
    val templatePath = "$workingPath/templates/feature/"

    File(targetPath).also {
        if (it.exists()) {
            it.deleteRecursively()
        }

        it.mkdirs()
    }

    listOf("cart").forEach {
        FeatureTemplate(
            targetPath,
            templatePath,
            rootPackageName,
            featurePackageName,
            it
        ).run()
    }


}

private fun isSkip(file: File): Boolean {

    if (file.absolutePath.endsWith(".DS_Store")) {
        return true
    }

    return false
}