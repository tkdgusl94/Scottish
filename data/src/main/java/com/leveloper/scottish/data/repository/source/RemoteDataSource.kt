package com.leveloper.scottish.data.repository.source

import com.leveloper.library.utils.Result

interface RemoteDataSource {
    suspend fun createChatRoom(name: String): Result<String>
}