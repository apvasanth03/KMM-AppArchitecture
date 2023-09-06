//
//  UserListScreenView.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI
import shared

// MARK: - UserListScreenView
struct UserListScreenView: View {
    
    @ObservedObject var viewModel: ObservableUserListViewModel
    
    var body: some View {
        let state = viewModel.uiStatePublished
        
        if let state = state {
            UserListScreenContentView(state: state)
        }
    }
}
