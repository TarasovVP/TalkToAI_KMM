import di.appModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

public fun doInitKoin() {
    print("doInitKoin")
}/*: KoinApplication = startKoin {
    modules(appModule, iosModule)
}*/