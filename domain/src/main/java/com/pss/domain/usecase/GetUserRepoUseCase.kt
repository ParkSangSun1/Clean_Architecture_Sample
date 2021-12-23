package com.pss.domain.usecase

import com.pss.domain.utils.RemoteErrorEmitter
import com.pss.domain.repository.GithubRepository
import javax.inject.Inject

class GetUserRepoUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, owner : String) = githubRepository.getGithub(remoteErrorEmitter, owner)
}