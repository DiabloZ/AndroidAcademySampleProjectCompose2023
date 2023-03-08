package com.suhov.aaspc2023.data.stores

import com.suhov.aaspc2023.domain.models.GitHubRepositoriesItem
import com.suhov.aaspc2023.ui.screens.core.LoadingSate
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

	private val _loadingStateFlow: MutableStateFlow<LoadingSate> = MutableStateFlow(LoadingSate.Default)
	override val loadingStateFlow: StateFlow<LoadingSate> = _loadingStateFlow

	override suspend fun setLoading(newState: LoadingSate) {
		_loadingStateFlow.emit(newState)
	}

}

interface ErrorSessionStore {

	val loadingStateFlow: StateFlow<LoadingSate>
	suspend fun setLoading(newState: LoadingSate)

}