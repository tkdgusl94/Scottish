package com.leveloper.scottish.domain.repository

import com.leveloper.library.utils.Result
import com.leveloper.scottish.domain.model.ChatRoom
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun createChatRoom(name: String)
    suspend fun getAllChatRoom(): Flow<Result<List<ChatRoom>>>
}