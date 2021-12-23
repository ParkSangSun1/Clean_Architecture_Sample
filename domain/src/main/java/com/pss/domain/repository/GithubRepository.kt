package com.pss.domain.repository

import com.pss.domain.utils.RemoteErrorEmitter
import com.pss.domain.model.GithubResponse

interface GithubRepository {
    suspend fun getGithub(remoteErrorEmitter: RemoteErrorEmitter, owner : String) : List<GithubResponse>?
}