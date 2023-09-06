//
//  UserListErrorView.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI

// MARK: - UserListErrorView
struct UserListErrorView: View {
    var body: some View {
        VStack(spacing: 12) {
            Spacer(minLength: 0)
            
            Image("ic_error_outline")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 84, height: 84)
            
            
            
            Text("Unexpected Error")
                .font(.body)
            
            Spacer(minLength: 0)
        }
    }
}

// MARK: - Previews
struct UserListErrorView_Previews: PreviewProvider {
    static var previews: some View {
        UserListErrorView()
    }
}
