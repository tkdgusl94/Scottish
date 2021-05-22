package com.leveloper.scottish.repository.impl

import com.leveloper.library.utils.Result
import com.leveloper.scottish.db.entity.TestEntity
import com.leveloper.scottish.db.dao.TestDao
import com.leveloper.scottish.repository.TestRepository
import java.lang.Exception
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val testDao: TestDao
) : TestRepository {

    override fun insert(value: String): Result<Long> {
        return try {
            val entity =
                TestEntity(name = value)
            val id = testDao.insert(entity)

            Result.Success(id)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}