package com.leveloper.scottish.di

import com.leveloper.scottish.repository.TestRepository
import com.leveloper.scottish.repository.impl.TestRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTestRepository(
        repository: TestRepositoryImpl
    ): TestRepository {
        return repository
    }
}