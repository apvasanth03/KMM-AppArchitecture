//
//  UserListScreenContent.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI
import shared

// MARK: - UserListScreenContent
struct UserListScreenContentView: View {
    
    let state: UserListUIState
    
    var body: some View {
        if let _ = state as? UserListUIStateLoading {
            UserListLoadingView()
        } else if let data = state as? UserListUIStateData {
            UserListDataView(users: data.users)
        } else if let _ = state as? UserListUIStateError {
            UserListErrorView()
        }
    }
}

// MARK: - Previews
struct UserListScreenContentView_Previews: PreviewProvider {
    static var previews: some View {
        let state = UserListSampleData.createDataUIState()
        
        UserListScreenContentView(state: state)
    }
}
