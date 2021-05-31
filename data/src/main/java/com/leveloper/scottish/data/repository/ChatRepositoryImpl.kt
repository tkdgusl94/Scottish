package com.leveloper.scottish.data.repository

import com.leveloper.scottish.data.repository.source.LocalDataSource
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import com.leveloper.scottish.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ChatRepository {

    override suspend fun createChatRoom(name: String) {
        val abc = remoteDataSource.createChatRoom(name)
    }
}