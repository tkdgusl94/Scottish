package com.leveloper.scottish.domain.usecase.test

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.repository.ChatRepository
import com.leveloper.scottish.domain.usecase.UseCase
import javax.inject.Inject

class CreateChatRoom @Inject constructor(
    private val chatRepository: ChatRepository
) : UseCase<Unit, CreateChatRoom.Param>() {

    override suspend fun run(params: Param): Result<Unit> {
        chatRepository.createChatRoom(params.name)
        return Result.Success(Unit)
    }

    data class Param(
        val name: String
    )
}