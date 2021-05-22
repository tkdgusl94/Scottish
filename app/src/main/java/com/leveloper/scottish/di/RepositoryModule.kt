package com.leveloper.scottish.di

import com.leveloper.scottish.data.repository.SampleRepositoryImpl
import com.leveloper.scottish.domain.repository.SampleRepository
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
        repository: SampleRepositoryImpl
    ): SampleRepository {
        return repository
    }
}