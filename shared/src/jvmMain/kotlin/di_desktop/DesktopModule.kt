package di_desktop

import data.database.DatabaseDriverFactory
import org.koin.dsl.module

val desktopModule = module {
    single {
        DatabaseDriverFactory()
    }
}