package com.suhov.aaspc2023.data.stores

import com.suhov.aaspc2023.data.models.GitHubRepositoriesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Single

@Single
class SessionStore {


	private val rawReposStateFlow: MutableStateFlow<List<GitHubRepositoriesItem>?> = MutableStateFlow(null)

	suspend fun setRepos(newList: List<GitHubRepositoriesItem>){
		rawReposStateFlow.emit(newList)
	}

	fun getReposStateFlow(): StateFlow<List<GitHubRepositoriesItem>?> = rawReposStateFlow

}