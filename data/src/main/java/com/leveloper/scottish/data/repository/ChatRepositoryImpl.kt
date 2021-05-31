package com.leveloper.scottish.data.repository

import com.leveloper.library.utils.Result
import com.leveloper.scottish.data.repository.source.LocalDataSource
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import com.leveloper.scottish.domain.model.ChatRoom
import com.leveloper.scottish.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ChatRepository {

    override suspend fun createChatRoom(name: String) {
        val abc = remoteDataSource.createChatRoom(name)
    }

    override suspend fun getAllChatRoom(): Flow<Result<List<ChatRoom>>> {
        return remoteDataSource.getAllChatRoom()
    }
}