import UIKit
import Combine
import shared
import SwiftUI

class UserListViewController: UIViewController {
    
    // MARK: - Properties.
    fileprivate lazy var userListVM = ObservableUserListViewModel()
    fileprivate lazy var contentVC = UIHostingController(
        rootView: UserListScreenView(viewModel: userListVM)
    )
    fileprivate var cancellables = [AnyCancellable]()
    fileprivate var users: [UserUIModel] = []
    
    // MARK: - UIViewController Methods.
    override func viewDidLoad() {
        super.viewDidLoad()
        
        activateVM()
        initializeViews()
    }
    
    deinit {
        userListVM.deactivate()
    }
    
    // MARK: - Private Methods.
    private func activateVM(){
        userListVM.activate()
    }
    
    private func initializeViews(){
        self.title = "User List"
        
        addChild(contentVC)
        view.addSubview(contentVC.view)
        setupConstraints()
        
    }
    
    private func setupConstraints(){
        contentVC.view.translatesAutoresizingMaskIntoConstraints = false
        contentVC.view.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        contentVC.view.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
        contentVC.view.leftAnchor.constraint(equalTo: view.leftAnchor).isActive = true
        contentVC.view.rightAnchor.constraint(equalTo: view.rightAnchor).isActive = true
    }
}



