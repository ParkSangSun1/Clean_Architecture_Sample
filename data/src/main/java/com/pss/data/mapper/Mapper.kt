package com.pss.data.mapper

import com.pss.data.remote.model.GithubResponse

object Mapper {
    fun mapperGithub(response: List<GithubResponse>?) : List<com.pss.domain.model.GithubResponse>? {
        return if (response != null){
            response.toDomain()
        } else null
    }

    fun List<GithubResponse>.toDomain() : List<com.pss.domain.model.GithubResponse> {
        return this.map {
            com.pss.domain.model.GithubResponse(
                it.name,
                it.id,
                it.date,
                it.url
            )
        }
    }
}