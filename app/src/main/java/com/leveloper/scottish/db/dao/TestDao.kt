package com.leveloper.scottish.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.leveloper.scottish.db.TestEntity

@Dao
interface TestDao {

    @Insert
    fun insert(obj: TestEntity): Long
}