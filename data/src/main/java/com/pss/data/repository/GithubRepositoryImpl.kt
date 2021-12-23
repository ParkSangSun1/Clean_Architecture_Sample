package com.pss.data.repository

import com.pss.data.mapper.Mapper
import com.pss.domain.utils.RemoteErrorEmitter
import com.pss.data.repository.remote.datasource.GithubDataSource
import com.pss.domain.model.GithubResponse
import com.pss.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubDataSource: GithubDataSource
) : GithubRepository {
    override suspend fun getGithub(
        remoteErrorEmitter: RemoteErrorEmitter,
        owner: String
    ): List<GithubResponse>? {
        return Mapper.mapperGithub(githubDataSource.getGithub(remoteErrorEmitter, owner))
    }
}