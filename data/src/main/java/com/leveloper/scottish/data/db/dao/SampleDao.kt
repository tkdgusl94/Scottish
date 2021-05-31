package com.leveloper.scottish.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.leveloper.scottish.data.model.entity.SampleEntity

@Dao
interface SampleDao {

    @Insert
    fun insert(obj: SampleEntity): Long
}