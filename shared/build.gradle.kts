
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
    kotlin("plugin.serialization") version "1.8.21"
}

kotlin {

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
    
    jvm()
    
    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            implementation("com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion")
            implementation("io.insert-koin:koin-core:$koinVersion")
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
