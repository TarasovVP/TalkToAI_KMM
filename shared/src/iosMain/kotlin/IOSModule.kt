import data.database.DatabaseDriverFactory
import org.koin.dsl.module

val iosModule = module {
    single {
        DatabaseDriverFactory()
    }
}