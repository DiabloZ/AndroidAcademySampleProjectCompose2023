package com.suhov.aaspc2023.ui.base


import androidx.lifecycle.ViewModel
import com.suhov.aaspc2023.data.stores.SessionStore
import com.suhov.aaspc2023.domain.usecases.GitHubUseCases
import com.suhov.aaspc2023.data.utils.TimeConstants.IMMEDIATELY
import org.koin.android.annotation.KoinViewModel
import timber.log.Timber

@KoinViewModel
class MainActivityViewModel(
	sessionStore: SessionStore,
	private val gitHubUseCases: GitHubUseCases
): ViewModel() {

	val gitHubRepoData = sessionStore.reposStateFlow

	fun getRepos(){
		gitHubUseCases.getRepos(IMMEDIATELY)
		Timber.e("MainActivityViewModel - getRepos")
	}
}