//
//  UserListLoadingView.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import SwiftUI

// MARK: - UserListLoadingView
struct UserListLoadingView: View {
    var body: some View {
        VStack {
            Spacer()
            
            ProgressView()
                .progressViewStyle(.circular)
            
            Spacer()
        }
    }
}

// MARK: - Preview
struct UserListLoadingView_Previews: PreviewProvider {
    static var previews: some View {
        UserListLoadingView()
    }
}
