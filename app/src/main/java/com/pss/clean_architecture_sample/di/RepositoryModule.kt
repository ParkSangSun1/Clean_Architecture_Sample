package com.pss.clean_architecture_sample.di

import com.pss.data.repository.GithubRepositoryImpl
import com.pss.data.repository.remote.datasourceImpl.GithubDataSourceImpl
import com.pss.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        githubDataSourceImpl: GithubDataSourceImpl
    ): GithubRepository {
        return GithubRepositoryImpl(
            githubDataSourceImpl
        )
    }
}