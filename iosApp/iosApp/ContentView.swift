import UIKit
import SwiftUI
import ComposeApp
import shared

struct ComposeView: UIViewControllerRepresentable {
    
    let chatViewModel: ChatViewModel? = {
        do {
            return try KoinHelper().getChatViewModel()
        } catch {
            print(error)
            return nil
        }
    }()
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(viewModel: chatViewModel)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
}

struct ContentView: View {

    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard)// Compose has own keyboard handler
    }
}



