package di

import com.vnteam.talktoai.AppDatabase
import data.database.DatabaseDriverFactory
import data.database.dao.ChatDao
import data.database.dao.ChatDaoImpl
import data.database.dao.MessageDao
import data.database.dao.MessageDaoImpl
import data.network.ApiService
import data.repositoryimpls.ChatRepositoryImpl
import data.repositoryimpls.MessageRepositoryImpl
import domain.repositories.ChatRepository
import domain.repositories.MessageRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {
    single { ApiService(getProperty("BASE_URL"), get()) }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(DefaultRequest) {
                header("Content-Type", "application/json")
                header("Authorization", "Bearer ${getProperty<String>("OPENAI_API_KEY")}")
                header("OpenAI-Organization", getProperty<String>("ORGANIZATION_ID"))
            }
        }
    }
    single {
        val sqlDriver = get<DatabaseDriverFactory>().createDriver()
        AppDatabase(sqlDriver)
    }

    single<ChatDao> { ChatDaoImpl(get<AppDatabase>().appDatabaseQueries) }
    single<MessageDao> { MessageDaoImpl(get<AppDatabase>().appDatabaseQueries) }
    single<ChatRepository> {
        ChatRepositoryImpl(
            chatDao = get()
        )
    }
    single<MessageRepository> {
        MessageRepositoryImpl(
            messageDao = get(),
            apiService = get()
        )
    }
}