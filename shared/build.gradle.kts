import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.serialization)
    kotlin("native.cocoapods")
}

kotlin {
    val serialization = "1.5.1"
    val ktorVersion = "2.3.7"
    val sqlDelightVersion = "1.5.5"
    val coroutinesVersion = "1.7.3"
    val koinVersion = "3.5.3"
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        name = "AppCocoaPod"

        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = false
            embedBitcode(BitcodeEmbeddingMode.BITCODE)
        }
        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = NativeBuildType.RELEASE
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            transitiveExport = true
            compilations.all {
                kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
            }
        }
    }
    
    jvm()
    
    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            implementation("com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion")
            implementation("io.insert-koin:koin-core:$koinVersion")
            implementation("io.insert-koin:koin-compose:1.1.2")
            implementation("io.insert-koin:koin-test:$koinVersion")
        }
        androidMain.dependencies {
            implementation("io.ktor:ktor-client-android:$ktorVersion")
            implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            implementation("io.insert-koin:koin-android:$koinVersion")
            implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
        }
        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
        }
        jvmMain.dependencies {
            implementation("io.ktor:ktor-client-java:$ktorVersion")
            implementation("com.squareup.sqldelight:sqlite-driver:$sqlDelightVersion")
        }
        nativeMain.dependencies {
            implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
        }
    }

}

android {
    namespace = "com.vnteam.talktoai.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.vnteam.talktoai"
    }
}
