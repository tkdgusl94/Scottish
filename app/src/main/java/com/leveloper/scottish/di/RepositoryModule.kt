package com.leveloper.scottish.di

import com.leveloper.scottish.data.repository.ChatRepositoryImpl
import com.leveloper.scottish.data.repository.SampleRepositoryImpl
import com.leveloper.scottish.data.repository.source.LocalDataSource
import com.leveloper.scottish.data.repository.source.RemoteDataSource
import com.leveloper.scottish.data.repository.source.impl.LocalDataSourceImpl
import com.leveloper.scottish.data.repository.source.impl.RemoteDataSourceImpl
import com.leveloper.scottish.domain.repository.ChatRepository
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

    @Singleton
    @Provides
    fun provideChatRepository(repository: ChatRepositoryImpl) : ChatRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(dataSource: LocalDataSourceImpl): LocalDataSource {
        return dataSource
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(dataSource: RemoteDataSourceImpl): RemoteDataSource {
        return dataSource
    }
}