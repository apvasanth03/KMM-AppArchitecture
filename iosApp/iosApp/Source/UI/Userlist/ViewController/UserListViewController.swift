import UIKit
import Combine
import shared

class UserListViewController: BaseKMMViewController<UserListViewModel> {
    
    // MARK: - Properties.
    @IBOutlet weak var aiProgress: UIActivityIndicatorView!
    @IBOutlet weak var tvUser: UITableView!
    @IBOutlet weak var vError: ErrorView!
    
    fileprivate var cancellables = [AnyCancellable]()
    fileprivate var users: [UserUIModel] = []
    
    // MARK: - UIViewController Methods.
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initializeDependencies()
        initializeViews()
        setUpViewModelBindings()
    }
    
    // MARK: - Private Methods.
    private func initializeDependencies(){
        viewModel = SharedLibComponent.shared.userListViewModel()
    }
    
    private func initializeViews(){
        self.title = "User List"
        
        initializeLoadingView()
        initializeTableView()
        initializeErrorView()
    }
    
    private func initializeLoadingView(){
        aiProgress.stopAnimating()
    }
    
    private func initializeTableView(){
        tvUser.register(UINib(nibName: UserTableViewCell.IDENTIFIER, bundle: nil), forCellReuseIdentifier: UserTableViewCell.IDENTIFIER)
        tvUser.estimatedRowHeight = 100
        tvUser.rowHeight = UITableView.automaticDimension
        tvUser.dataSource = self
        tvUser.delegate = self
    }
    
    private func initializeErrorView(){
        vError.icon = UIImage(named: "ic_error_outline")
        vError.title = "Unexpected Error"
        vError.message = "Something went wrong. Please try again later"
    }
    
    fileprivate func setUpViewModelBindings(){
        doPublish(viewModel.uiStateAsCallback, onEach: { [weak self] uiState in
            self?.renderUIState(uiState: uiState)
        }).store(in: &cancellables)
    }
}

// MARK: - ViewModel Bindings Extension
extension UserListViewController{
    
    // MARK: - Render UIState
    private func renderUIState(uiState: UserListUIState){
        if let _ = uiState as? UserListUIStateLoading {
            renderLoadingState()
        } else if let data = uiState as? UserListUIStateData {
            renderDataState(data: data)
        } else if let _ = uiState as? UserListUIStateError {
            renderErrorState()
        }
    }
    
    private func renderLoadingState(){
        aiProgress.startAnimating()
        
        tvUser.isHidden = true
        
        vError.isHidden = true
    }
    
    private func renderDataState(data: UserListUIStateData){
        aiProgress.stopAnimating()
        
        tvUser.isHidden = false
        self.users = data.users
        tvUser.reloadData()
        
        vError.isHidden = true
    }
    
    private func renderErrorState(){
        aiProgress.stopAnimating()
        
        tvUser.isHidden = true
        
        vError.isHidden = false
    }
}

// MARK: - UITableViewDataSource
extension UserListViewController: UITableViewDataSource{
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return users.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let user = users[indexPath.row]
        let userCell = tableView.dequeueReusableCell(
            withIdentifier: UserTableViewCell.IDENTIFIER,
            for: indexPath
        ) as! UserTableViewCell
        
        userCell.populateCell(user: user)
        
        return userCell
    }
}

// MARK: - UITableViewDataSource
extension UserListViewController: UITableViewDelegate{
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let user = users[indexPath.row]
        let event = UserListEventItemClicked(user: user)
        viewModel.handleEvent(event: event)
    }
}



