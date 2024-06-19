package di_desktop

import di.appModule
import org.koin.core.context.startKoin

fun doInitKoin() = startKoin {
    modules(appModule, desktopModule)
}