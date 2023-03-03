package com.suhov.aaspc2023.data.services

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.suhov.aaspc2023.data.models.GitHubRepositoriesItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiGitHubService {

	private const val baseGithubURL = "https://api.github.com/"

	private val gson: Gson by lazy {
		GsonBuilder()
			.setLenient()
			.create()
	}

	private val retrofit: Retrofit by lazy {
		Retrofit.Builder()
			.baseUrl(baseGithubURL)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build()
	}
	private val gitHubApi: ApiGitHub by lazy {
		retrofit.create(ApiGitHub::class.java)
	}

	suspend fun getRepo(): Response<List<GitHubRepositoriesItem>> {
		return gitHubApi.getGitRepo()
	}

}