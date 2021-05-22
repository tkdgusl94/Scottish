package com.leveloper.scottish.repository

import com.leveloper.scottish.data.LvError
import com.leveloper.scottish.data.LvResult
import com.leveloper.scottish.data.LvSuccess
import com.leveloper.scottish.db.TestEntity
import com.leveloper.scottish.db.dao.TestDao
import java.lang.Exception
import javax.inject.Inject

interface TestRepository {
    fun insert(value: String): LvResult<Long>
}

class TestRepositoryImpl @Inject constructor(
    private val testDao: TestDao
) : TestRepository {

    override fun insert(value: String): LvResult<Long> {
        return try {
            val entity = TestEntity(name = value)
            val id = testDao.insert(entity)

            LvSuccess(id)
            LvError(Exception())
        } catch (e: Exception) {
            LvError(e)
        }
    }
}