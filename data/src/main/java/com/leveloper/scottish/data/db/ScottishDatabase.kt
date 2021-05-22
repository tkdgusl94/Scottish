package com.leveloper.scottish.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leveloper.scottish.data.db.dao.SampleDao
import com.leveloper.scottish.data.model.SampleEntity

@Database(
    entities = [
        SampleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ScottishDatabase : RoomDatabase() {
    abstract fun tripDao(): SampleDao
}