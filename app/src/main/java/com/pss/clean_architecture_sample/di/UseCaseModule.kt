package com.pss.clean_architecture_sample.di

import com.pss.domain.repository.GithubRepository
import com.pss.domain.usecase.GetUserRepoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserRepoUseCase(repository: GithubRepository) = GetUserRepoUseCase(repository)
}