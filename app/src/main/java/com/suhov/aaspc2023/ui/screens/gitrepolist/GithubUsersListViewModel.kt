package com.suhov.aaspc2023.ui.screens.gitrepolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suhov.aaspc2023.data.stores.GithubUsersListStore
import com.suhov.aaspc2023.domain.models.GitHubUserItem
import com.suhov.aaspc2023.domain.usecases.GitHubUseCases
import com.suhov.aaspc2023.ui.screens.core.LoadingState
import com.suhov.aaspc2023.ui.screens.core.isLoading
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.koin.android.annotation.KoinViewModel
import timber.log.Timber

@KoinViewModel
class GithubUsersListViewModel(
	private val gitHubUseCases: GitHubUseCases,
	private val githubUsersListStore: GithubUsersListStore
) : ViewModel() {

	private val _state: MutableStateFlow<GithubUsersListState> = MutableStateFlow(GithubUsersListState.initializeState)
	val state: StateFlow<GithubUsersListState> = _state
	private val createStateMutex = Mutex()

	init {
		viewModelScope.safeLaunch {
			githubUsersListStore.reposStateFlow.collectAsync { usersList ->
				createState(usersList = usersList)
			}
			
			githubUsersListStore.loadingStateFlow.collectAsync { loadState ->
				createState(loadState = loadState)
			}

			githubUsersListStore.errorStateFlow.collectAsync { isError ->
				createState(isError = isError)
			}
		}
	}

	fun pushIntent(intent: GithubUsersListScreenIntent){
		when(intent){
			GithubUsersListScreenIntent.Loading -> getListOfUsers()
			GithubUsersListScreenIntent.GotError -> getListOfUsers()
			is GithubUsersListScreenIntent.ClickOnTheUser -> handleUsersClick(intent.userId)
		}
	}

	private fun handleUsersClick(userId: Int) {
		Timber.w("User click on the GithubUser - $userId")
	}

	private fun getListOfUsers() {
		gitHubUseCases.getRepos()
	}

	private suspend fun createState(
		loadState: LoadingState = githubUsersListStore.loadingStateFlow.value,
		usersList: List<GitHubUserItem>? = githubUsersListStore.reposStateFlow.value,
		isError: Boolean = githubUsersListStore.errorStateFlow.value
	) {
		createStateMutex.withLock {
			val newState = state.value.copy(
				isLoading = loadState.isLoading(),
				usersList = usersList,
				isError = isError,

			)
			viewModelScope.safeLaunch {
				_state.emit(newState)
			}
		}
	}

}

suspend inline fun <reified T> SharedFlow<T>.collectAsync(crossinline newValue: suspend (newValue: T) -> Unit) = coroutineScope<Unit> {
	this@collectAsync.collect { value ->
		newValue(value)
	}
}

fun CoroutineScope.safeLaunch(block: suspend CoroutineScope.() -> Unit): Job {
	return launch {
		try {
			block()
		} catch (e: Exception) {
			Timber.e(e)
		}
	}
	
}
fun CoroutineScope.safeAsync(block: suspend CoroutineScope.() -> Unit): Job {
	return async {
		try {
			block()  
		} catch (e: Exception) {
			Timber.e(e)
		}
	}
}