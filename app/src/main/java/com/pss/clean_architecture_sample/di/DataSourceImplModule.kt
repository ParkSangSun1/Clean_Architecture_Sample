package com.pss.clean_architecture_sample.di

import com.pss.data.remote.api.GithubApi
import com.pss.data.repository.remote.datasource.GithubDataSource
import com.pss.data.repository.remote.datasourceImpl.GithubDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceImplModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        githubApi: GithubApi
    ) : GithubDataSource {
        return GithubDataSourceImpl(
            githubApi
        )
    }
}