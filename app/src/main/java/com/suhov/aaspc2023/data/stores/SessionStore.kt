package com.suhov.aaspc2023.data.stores

import com.suhov.aaspc2023.domain.models.GitHubUserItem
import com.suhov.aaspc2023.ui.screens.core.LoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.annotation.Single

@Single
class SessionStore: GithubUsersListStore, ErrorSessionStore {

	private val rawReposStateFlow: MutableStateFlow<List<GitHubUserItem>?> = MutableStateFlow(null)
	override val reposStateFlow: StateFlow<List<GitHubUserItem>?> = rawReposStateFlow

	override suspend fun setRepos(newList: List<GitHubUserItem>){
		rawReposStateFlow.emit(newList)
	}

	private val _loadingStateFlow: MutableStateFlow<LoadingState> = MutableStateFlow(LoadingState.Default)
	override val loadingStateFlow: StateFlow<LoadingState> = _loadingStateFlow

	override suspend fun setLoading(newState: LoadingState) {
		_loadingStateFlow.emit(newState)
	}
	private val _errorStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
	override val errorStateFlow: StateFlow<Boolean> = _errorStateFlow

	override suspend fun setError(isError: Boolean) {
		_errorStateFlow.emit(isError)
	}

}

interface ErrorSessionStore {

	val loadingStateFlow: StateFlow<LoadingState>
	suspend fun setLoading(newState: LoadingState)

}

interface GithubUsersListStore {

	val reposStateFlow: StateFlow<List<GitHubUserItem>?>
	suspend fun setRepos(newList: List<GitHubUserItem>)

	val loadingStateFlow: StateFlow<LoadingState>
	suspend fun setLoading(newState: LoadingState)

	val errorStateFlow: StateFlow<Boolean>
	suspend fun setError(isError: Boolean)

}