package com.leveloper.scottish.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leveloper.scottish.db.dao.TestDao

@Database(
    entities = [
        TestEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ScottishDatabase : RoomDatabase() {
    abstract fun tripDao(): TestDao
}