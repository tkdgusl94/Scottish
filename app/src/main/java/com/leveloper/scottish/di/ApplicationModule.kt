package com.leveloper.scottish.di

import android.content.Context
import androidx.room.Room
import com.leveloper.scottish.db.ScottishDatabase
import com.leveloper.scottish.db.dao.TestDao
import com.leveloper.scottish.repository.TestRepository
import com.leveloper.scottish.repository.TestRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

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
    fun provideTestDao(
        database: ScottishDatabase
    ): TestDao {
        return database.tripDao()
    }

    @Singleton
    @Provides
    fun provideTestRepository(
        repository: TestRepositoryImpl
    ): TestRepository {
        return repository
    }
}