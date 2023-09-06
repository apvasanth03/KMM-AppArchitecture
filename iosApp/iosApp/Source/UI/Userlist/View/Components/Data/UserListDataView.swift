//
//  USerListDataView.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI
import shared

// MARK: - UserListDataView
struct UserListDataView: View {
    
    let users: [UserUIModel]
    
    var body: some View {
        List(users) { user in
            UserItemView(user: user)
        }
    }
}

// MARK: - Previews
struct UserListDataView_Previews: PreviewProvider {
    static var previews: some View {
        let users = UserListSampleData.createUserUIModels()
        
        UserListDataView(users: users)
    }
}
