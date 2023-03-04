package com.suhov.aaspc2023.data.stores

import com.suhov.aaspc2023.data.models.GitHubRepositoriesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Single

@Single
class SessionStore: ErrorSessionStore {

	private val rawReposStateFlow: MutableStateFlow<List<GitHubRepositoriesItem>?> = MutableStateFlow(null)
	val reposStateFlow: StateFlow<List<GitHubRepositoriesItem>?> = rawReposStateFlow

	suspend fun setRepos(newList: List<GitHubRepositoriesItem>){
		rawReposStateFlow.emit(newList)
	}

	private val _loadingStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
	override val loadingStateFlow: StateFlow<Boolean> = _loadingStateFlow

	override suspend fun setLoading(isLoading: Boolean) {
		_loadingStateFlow.emit(isLoading)
	}

}

interface ErrorSessionStore {

	val loadingStateFlow: StateFlow<Boolean>
	suspend fun setLoading(isLoading: Boolean)

}