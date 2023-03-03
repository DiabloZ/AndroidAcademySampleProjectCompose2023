package com.suhov.aaspc2023.data.usecases

import com.suhov.aaspc2023.data.services.ApiGitHubService
import com.suhov.aaspc2023.data.stores.SessionStore
import com.suhov.aaspc2023.data.utils.DispatchersProject
import com.suhov.aaspc2023.data.utils.TimeConstants.SECOND
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object GetRepos {

	private var getRepoJob: Job? = null

	operator fun invoke() {
		getRepoJob?.cancel()
		getRepoJob = DispatchersProject.ioScope.launch {
			delay(SECOND)
			val reposResult = ApiGitHubService.getRepo()
			when {
				reposResult.isSuccessful -> {
					val data = reposResult.body() ?: return@launch
					SessionStore.setRepos(data)
				}
				!reposResult.isSuccessful -> {

				}
			}
		}
	}

}
