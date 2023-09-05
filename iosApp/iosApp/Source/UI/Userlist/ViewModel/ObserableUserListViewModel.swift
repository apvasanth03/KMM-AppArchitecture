//
//  ObserableUserListViewModel.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 05/09/23.
//

import Foundation
import shared
import Combine

class ObservableUserListViewModel: ObservableObject {
    
    // MARK: - Properties.
    private var viewModel: UserListViewModel?
    private var cancellables = [AnyCancellable]()
    
    @Published
    private(set) var uiStatePublished: UserListUIState?
    
    @Published
    private(set) var sideEffectPublished: UserListSideEffect?
    
    // MARK: - Public Methods
    func activate(){
        let viewModel = SharedLibComponent.shared.userListViewModel()
        
        doPublish(viewModel.uiStateAsCallback, onEach: { [weak self] uiState in
            self?.uiStatePublished = uiState
        }).store(in: &cancellables)
        
        doPublish(viewModel.sideEffectAsCallback, onEach: { [weak self] sideEffect in
            self?.sideEffectPublished = sideEffect
        }).store(in: &cancellables)
        
        self.viewModel = viewModel
    }
    
    func deactivate(){
        cancellables.forEach { $0.cancel() }
        cancellables.removeAll()
        
        viewModel?.clear()
        viewModel = nil
    }
    
    func handleEvent(event: UserListEvent) {
        viewModel?.handleEvent(event: event)
    }
    
    
}
