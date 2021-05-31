package com.leveloper.scottish.data.repository.source.impl

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.leveloper.library.utils.Result
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.resumeWithException

class RemoteDataSourceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : RemoteDataSource {

    override suspend fun createChatRoom(name: String): Result<String> {
        return try {
            val chatRoom = ChatRoom(name)

            val result = fireStore.collection("Chat_rooms")
                .add(chatRoom)
                .await()

            Result.Success(result.id)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}

data class ChatRoom(
    val name: String
)

suspend fun <T> Task<T>.await(): T {
    if (isComplete) {
        val e = exception
        return if (e == null) {
            if (isCanceled) {
                throw CancellationException("Task $this was cancelled normally.")
            } else {
                result!!
            }
        } else {
            throw e
        }
    }

    return suspendCancellableCoroutine { cont ->
        addOnCompleteListener {
            val e = exception
            if (e == null) {
                if (isCanceled) cont.cancel() else cont.resume(result!!, null)
            } else {
                cont.resumeWithException(e)
            }
        }
    }
}