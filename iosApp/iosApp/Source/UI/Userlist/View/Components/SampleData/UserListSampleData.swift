//
//  UserListSampleData.swift
//  iosApp
//
//  Created by Vasanthakumar Annadurai on 06/09/23.
//

import Foundation
import shared

struct UserListSampleData {
    
    static func createUserUIModel(id: Int64) -> UserUIModel {
        let user = UserUIModel(
            id: id,
            name: "Vasanth",
            email: "test@email.com",
            avatar: "https://picsum.photos/200/300"
        )
        return user
    }
    
    static func createUserUIModels() -> [UserUIModel] {
        var users = [UserUIModel]()
        for id in 0..<5 {
            users.append(createUserUIModel(id: Int64(id)))
        }
        return users
    }
    
    static func createDataUIState() -> UserListUIStateData {
        let state = UserListUIStateData(
            users: createUserUIModels()
        )
        return state
    }
}
