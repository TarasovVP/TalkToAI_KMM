package di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun doInitKoin(): KoinApplication = startKoin {
    modules(appModule, desktopModule)
    properties(mapOf("OPENAI_API_KEY" to "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", "ORGANIZATION_ID" to "org-4itqjgGWSLABAYvn8G0rxjrE", "BASE_URL" to "https://api.openai.com/v1/", "SERVER_CLIENT_ID" to "з1017477912088-q10is2j8a05iqc2tb74re0c7grg2d1ai.apps.googleusercontent.com", "REALTIME_DATABASE" to "1017477912088-q10is2j8a05iqc2tb74re0c7grg2d1ai.apps.googleusercontent.com"))
}