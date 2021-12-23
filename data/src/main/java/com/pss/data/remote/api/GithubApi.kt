package com.pss.data.remote.api

import com.pss.data.remote.model.GithubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String) : Response<List<GithubResponse>>
}