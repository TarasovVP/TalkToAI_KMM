import UIKit
import SwiftUI
import ComposeApp
import shared

struct ComposeView: UIViewControllerRepresentable {
    
    var testClass: TestClass = TestClass()
    
    init() {
        testClass = testClassValue()
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(anyObject: testClass.testValue)
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    func testClassValue() -> TestClass {
        let commonTestClass = KoinHelper().getMessageRepository().getTest()
        let iosTestClass = TestClass()
        iosTestClass.testValue = commonTestClass.testValue
        return iosTestClass
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



