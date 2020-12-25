import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(App.sdk)
    defaultConfig {
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.sdk)
        versionCode = 1
        versionName = App.version
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))

    implementation(project(Features.Core.common))
    implementation(project(Features.Core.moduleInjector))
    implementation(Depends.RxJava.core)
    implementation(Depends.RxJava.android)


    testImplementation(Depends.jUnit)
    androidTestImplementation(Depends.AndroidX.junit)
    androidTestImplementation(Depends.AndroidX.espressoCore)
}