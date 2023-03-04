package com.suhov.aaspc2023.ui.screens.errorloaddata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suhov.aaspc2023.data.stores.ErrorSessionStore
import com.suhov.aaspc2023.data.usecases.GitHubUseCases
import com.suhov.aaspc2023.data.utils.TimeConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ErrorViewModel(
	private val gitHubUseCases: GitHubUseCases,
	private val errorStateStore: ErrorSessionStore
): ViewModel() {

	private val _state: MutableStateFlow<ErrorScreenState> = MutableStateFlow(ErrorScreenState.initializeState)
	val state: StateFlow<ErrorScreenState> = _state

	init {
		viewModelScope.launch {
			errorStateStore.loadingStateFlow.collect { isLoading ->
				createState(isLoading)
			}
		}
	}

	fun pushIntent(intent: ErrorScreenIntent){
		when(intent){
			is ErrorScreenIntent.clickOnLink -> {
				intent.link
			}
			ErrorScreenIntent.clickOnRefresh -> loadData()
		}
	}

	private fun createState(isLoading: Boolean) {
		val newState = state.value.copy(
			isLoading = isLoading,
			textLoadButton = if (isLoading) "isLoading" else "isError"
		)
		setNewState(newState)
	}

	private fun loadData() {
		gitHubUseCases.getRepos()
	}

	private fun setNewState(newState: ErrorScreenState) {
		viewModelScope.launch {
			_state.emit(newState)
		}
	}

}