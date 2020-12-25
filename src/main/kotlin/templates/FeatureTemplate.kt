package templates

import commands.Command
import commands.CopyTemplatedFileCommand
import commands.CreateDirectoryCommand

class FeatureTemplate(
    targetPath: String,
    templatePath: String,
    rootPackageName: String,
    packageName: String,
    featureName: String
) : Template {

    private val featurePath = "$targetPath/$featureName"
    private val sourcePath = "${packageName.replace(".", "/")}/$featureName"

    private val variables = hashMapOf(
        "packageName" to packageName,
        "featureName" to featureName,
        "featureNameCamelCase" to featureName.capitalize(),
        "rootPackageName" to rootPackageName
    )


    private val commands = listOf(
        // API
        CreateDirectoryCommand("$featurePath/api"),
        CopyTemplatedFileCommand(
            "$templatePath/api/.gitignore",
            "$featurePath/api/.gitignore",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/api/build.gradle.kts",
            "$featurePath/api/build.gradle.kts",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/api/consumer-rules.pro",
            "$featurePath/api/consumer-rules.pro",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/api/proguard-rules.pro",
            "$featurePath/api/proguard-rules.pro",
            variables
        ),
        CreateDirectoryCommand("$featurePath/api/libs"),
        CreateDirectoryCommand("$featurePath/api/src/main/java/$sourcePath/api"),
        CopyTemplatedFileCommand(
            "$templatePath/api/AndroidManifest.xml",
            "$featurePath/api/src/main/AndroidManifest.xml",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/api/src/FeatureApi.kt",
            "$featurePath/api/src/main/java/$sourcePath/api/${featureName.capitalize()}FeatureApi.kt",
            variables
        ),
        // impl
        CreateDirectoryCommand("$featurePath/impl"),
        CopyTemplatedFileCommand(
            "$templatePath/impl/.gitignore",
            "$featurePath/impl/.gitignore",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/build.gradle.kts",
            "$featurePath/impl/build.gradle.kts",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/consumer-rules.pro",
            "$featurePath/impl/consumer-rules.pro",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/proguard-rules.pro",
            "$featurePath/impl/proguard-rules.pro",
            variables
        ),
        CreateDirectoryCommand("$featurePath/impl/libs"),
        CreateDirectoryCommand("$featurePath/impl/src/main/java/$sourcePath/impl/di"),
        CopyTemplatedFileCommand(
            "$templatePath/impl/AndroidManifest.xml",
            "$featurePath/impl/src/main/AndroidManifest.xml",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/src/di/FeatureComponent.kt",
            "$featurePath/impl/src/main/java/$sourcePath/impl/di/${featureName.capitalize()}FeatureComponent.kt",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/src/di/ComponentHolder.kt",
            "$featurePath/impl/src/main/java/$sourcePath/impl/di/${featureName.capitalize()}ComponentHolder.kt",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/src/di/FeatureDependencies.kt",
            "$featurePath/impl/src/main/java/$sourcePath/impl/di/${featureName.capitalize()}FeatureDependencies.kt",
            variables
        ),
        CopyTemplatedFileCommand(
            "$templatePath/impl/src/di/FeatureModule.kt",
            "$featurePath/impl/src/main/java/$sourcePath/impl/di/${featureName.capitalize()}FeatureModule.kt",
            variables
        )

    )

    override fun run() {
        commands.forEach(Command::execute)
    }
}