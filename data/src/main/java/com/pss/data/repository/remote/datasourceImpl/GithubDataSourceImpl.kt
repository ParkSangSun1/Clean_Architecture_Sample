package com.pss.data.repository.remote.datasourceImpl

import com.pss.data.remote.api.GithubApi
import com.pss.data.remote.model.GithubResponse
import com.pss.data.utils.base.BaseRepository
import com.pss.domain.utils.RemoteErrorEmitter
import com.pss.data.repository.remote.datasource.GithubDataSource
import javax.inject.Inject

class GithubDataSourceImpl @Inject constructor(
    private val githubApi: GithubApi
) : BaseRepository(), GithubDataSource {
    override suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner : String): List<GithubResponse>? {
        return safeApiCall(remoteErrorEmitter){githubApi.getRepos(owner).body()}
    }
}