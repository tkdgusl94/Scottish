package com.leveloper.scottish.data.repository.source

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.model.ChatRoom
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun createChatRoom(name: String): Result<String>
    suspend fun getAllChatRoom(): Flow<Result<List<ChatRoom>>>
}