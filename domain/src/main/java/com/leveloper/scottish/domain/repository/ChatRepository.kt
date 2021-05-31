package com.leveloper.scottish.domain.repository

interface ChatRepository {
    suspend fun createChatRoom(name: String)
}