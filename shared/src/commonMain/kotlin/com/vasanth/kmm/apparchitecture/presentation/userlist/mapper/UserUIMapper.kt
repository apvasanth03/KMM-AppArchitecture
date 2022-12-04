package com.vasanth.kmm.apparchitecture.presentation.userlist.mapper

import com.vasanth.kmm.apparchitecture.data.model.User
import com.vasanth.kmm.apparchitecture.presentation.core.BaseMapper
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserUIModel
import kotlinx.coroutines.CoroutineDispatcher

class UserUIMapper constructor(
    dispatcher: CoroutineDispatcher
) : BaseMapper<User, UserUIModel>(dispatcher = dispatcher) {

    override suspend fun map(input: User): UserUIModel {
        return with(input) {
            val uiModel = UserUIModel(
                id = id,
                name = "$firstName $lastName",
                email = email,
                avatar = avatar
            )
            uiModel
        }
    }
}