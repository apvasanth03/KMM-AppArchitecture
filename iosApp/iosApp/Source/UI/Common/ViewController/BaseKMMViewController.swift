import UIKit
import shared

/// Base ViewController for all our KMM ViewController
class BaseKMMViewController<VM: ViewModel>: UIViewController {
    
    var viewModel: VM!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    deinit {
        viewModel.onCleared()
    }
    
}
