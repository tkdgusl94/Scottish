package com.leveloper.scottish.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.leveloper.library.utils.Result
import com.leveloper.scottish.data.db.dao.SampleDao
import com.leveloper.scottish.data.model.SampleEntity
import com.leveloper.scottish.data.model.map
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import com.leveloper.scottish.domain.model.Sample
import com.leveloper.scottish.domain.repository.SampleRepository
import java.lang.Exception
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val sampleDao: SampleDao,
    private val remoteDataSource: RemoteDataSource
) : SampleRepository {

    override fun insert(value: String): Result<Sample> {
        return try {
            val entity = SampleEntity(name = value)
            sampleDao.insert(entity)

            Result.Success(entity.map())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun abc() {
        val instance = FirebaseFirestore.getInstance()

        val sample = Sample(1, System.currentTimeMillis().toString())

        instance.collection("chat_rooms")

        instance.collection("users")
            .document("test")
            .set(sample)
//            .addOnSuccessListener {
//                println("success: ${it.id}")
//            }
            .addOnFailureListener {
                println("error: $it")
            }

        instance.collection("users")
            .document("test")
            .get()
            .addOnSuccessListener {
                println("get success: ${it.data}")
            }
    }
}