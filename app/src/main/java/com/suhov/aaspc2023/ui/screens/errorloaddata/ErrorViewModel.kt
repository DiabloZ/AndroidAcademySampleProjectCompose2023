package com.suhov.aaspc2023.ui.screens.errorloaddata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suhov.aaspc2023.data.stores.ErrorSessionStore
import com.suhov.aaspc2023.domain.usecases.GitHubUseCases
import com.suhov.aaspc2023.ui.screens.core.LoadingSate
import com.suhov.aaspc2023.ui.screens.core.isLoading
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
			errorStateStore.loadingStateFlow.collect { loadState ->
				createState(loadState)
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

	private fun createState(loadState: LoadingSate) {
		val newState = state.value.copy(
			isLoading = loadState.isLoading(),
			textLoadButton = when(loadState){
				is LoadingSate.Error -> "Caused an error, oops"
				LoadingSate.Default -> "Click on me for start loading"
				LoadingSate.Finished -> "We loaded and navigating you to the next screen"
				LoadingSate.Loading -> "We are loading now"
			}
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