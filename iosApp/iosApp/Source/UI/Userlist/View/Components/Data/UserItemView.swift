//
//  UserItemView.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI
import shared

// MARK: - UserItemView
struct UserItemView: View {
    
    let user: UserUIModel
    
    var body: some View {
        HStack {
            VStack(alignment: .leading, spacing: 5) {
                Text(user.name)
                
                Text(user.email)
            }
            
            Spacer()
        }
        .padding()
    }
}

// MARK: - Previews
struct UserItemView_Previews: PreviewProvider {
    static var previews: some View {
        let user = UserListSampleData.createUserUIModel(id: 1)
        
        UserItemView(user: user)
            .previewLayout(.fixed(width: 300, height: 75))
    }
}
