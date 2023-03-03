package com.suhov.aaspc2023.ui.base


import androidx.lifecycle.ViewModel
import com.suhov.aaspc2023.data.stores.SessionStore
import com.suhov.aaspc2023.data.usecases.GitHubCasesImplTimeTemp
import timber.log.Timber

class MainActivityViewModel: ViewModel() {

	private val gitHubUseCases = GitHubCasesImplTimeTemp
	private val sessionStore = SessionStore

	val gitHubRepoData = sessionStore.getReposStateFlow()

	fun getRepos(){
		gitHubUseCases.getRepos()
		Timber.e("MainActivityViewModel - getRepos")
	}
}