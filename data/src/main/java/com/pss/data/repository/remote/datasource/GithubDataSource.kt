package com.pss.data.repository.remote.datasource

import com.pss.data.remote.model.GithubResponse
import com.pss.domain.utils.RemoteErrorEmitter

interface GithubDataSource {
    suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner : String) : List<GithubResponse>?
}