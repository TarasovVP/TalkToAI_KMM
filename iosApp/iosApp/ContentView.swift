import UIKit
import SwiftUI
import ComposeApp
import shared

struct ComposeView: UIViewControllerRepresentable {
    let messageRepository = KoinHelper().getKoin()
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(anyObject: messageRepository)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



