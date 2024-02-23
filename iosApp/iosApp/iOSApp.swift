import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        KoinIOSKt.doInitKoin()

    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
