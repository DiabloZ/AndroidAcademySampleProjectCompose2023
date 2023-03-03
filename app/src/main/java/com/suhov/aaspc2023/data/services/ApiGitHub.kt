package com.suhov.aaspc2023.data.services

import com.suhov.aaspc2023.data.models.GitHubRepositoriesItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiGitHub {

	@GET("repositories")
	suspend fun getGitRepo(): Response<List<GitHubRepositoriesItem>>

}