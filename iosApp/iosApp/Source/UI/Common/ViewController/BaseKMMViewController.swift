import UIKit
import shared

class BaseKMMViewController<VM: ViewModel>: UIViewController {
    
    var viewModel: VM!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    deinit {
        viewModel.onCleared()
    }
    
}
