package com.leveloper.scottish.data.repository.source.impl

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.leveloper.library.utils.Result
import com.leveloper.scottish.data.model.dto.ChatRoomDto
import com.leveloper.scottish.data.model.dto.map
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import com.leveloper.scottish.domain.model.ChatRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val gson: Gson
) : RemoteDataSource {

    override suspend fun createChatRoom(name: String): Result<String> {
        return try {
            val chatRoom = ChatRoomDto(name)

            val result = fireStore.collection("Chat_rooms")
                .add(chatRoom)
                .await()

            Result.Success(result.id)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getAllChatRoom(): Flow<Result<List<ChatRoom>>> = flow {
        try {
            val current = System.currentTimeMillis()

            val list = fireStore.collection("Chat_rooms")
                .orderBy("name")
                .get()
                .await()
                .map {
                    val json = gson.toJsonTree(it.data)
                    gson.fromJson(json, ChatRoomDto::class.java).map(it.id)
                }

            println("time: ${System.currentTimeMillis() - current}")
            emit(Result.Success(list))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}