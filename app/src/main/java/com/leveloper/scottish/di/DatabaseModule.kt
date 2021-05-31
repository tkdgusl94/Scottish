package com.leveloper.scottish.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.leveloper.scottish.data.db.ScottishDatabase
import com.leveloper.scottish.data.db.dao.SampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "scottish.db"

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ScottishDatabase {
        return Room.databaseBuilder(context, ScottishDatabase::class.java, DB_NAME).build()
    }

    @Singleton
    @Provides
    fun provideTestDao(database: ScottishDatabase): SampleDao {
        return database.sampleDao()
    }

    @Singleton
    @Provides
    fun provideFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}