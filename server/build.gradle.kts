plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.sqlDelight)
    application
}

group = "com.vnteam.architecturetemplates"
version = "1.0.0"
application {
    mainClass.set("com.vnteam.talktoai.ApplicationKt")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(libs.logback)
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.ktor.server.tests)
    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    // Ktor
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    // DB
    implementation(libs.postgresql)
    implementation(libs.hikari.cp)
    implementation(libs.jdbc.driver)
}

sqldelight {
    databases {
        create("ServerDatabase") {
            packageName = "com.vnteam.architecturetemplates"
            dialect("app.cash.sqldelight:postgresql-dialect:2.0.2")
        }
    }
}