package com.vasanth.kmm.apparchitecture.domain.usecase

import com.vasanth.kmm.apparchitecture.data.model.User
import com.vasanth.kmm.apparchitecture.data.repository.UserRepository
import com.vasanth.kmm.apparchitecture.domain.core.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetUserListUseCase constructor(
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<GetUserListUseCase.Param, List<User>>(dispatcher) {

    data class Param(
        val page: Int
    )

    override suspend fun execute(parameters: Param): List<User> {
        return userRepository.getUsers(page = parameters.page)
    }
}