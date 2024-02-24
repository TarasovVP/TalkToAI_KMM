import UIKit
import SwiftUI
import ComposeApp
import shared
import Combine

struct ComposeView: UIViewControllerRepresentable {
   
    init() {
        getMessages()
    }
    
    
    var cancellables = Set<AnyCancellable>()

    func fetchMessages() {
        let repository = KoinHelper().getMessageRepository()
        repository.getMessages()
            .asPublisher() // Преобразование Flow в Publisher
            .receive(on: DispatchQueue.main)
            .sink(receiveCompletion: { completion in
                switch completion {
                case .finished:
                    break
                case .failure(let error):
                    print(error.localizedDescription)
                }
            }, receiveValue: { messages in
                print(messages)
            })
            .store(in: &cancellables)
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(obj: Any.self)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
}

struct ContentView: View {

    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard)// Compose has own keyboard handler
    }
}



