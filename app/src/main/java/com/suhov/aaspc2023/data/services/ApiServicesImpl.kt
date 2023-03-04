package com.suhov.aaspc2023.data.services

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.suhov.aaspc2023.R
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Single
class ApiServicesImpl(context: Context): ApiServices {

	private val baseGithubURL = context.getString(R.string.base_url_github)

	private val gson: Gson by lazy {
		GsonBuilder()
			.setLenient()
			.create()
	}

	private val retrofitGitHub: Retrofit by lazy {
		Retrofit.Builder()
			.baseUrl(baseGithubURL)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build()
	}

	override val gitHubApi: ApiGitHub by lazy {
		retrofitGitHub.create(ApiGitHub::class.java)
	}

}