package com.suhov.aaspc2023.domain.usecases

import com.suhov.aaspc2023.data.services.ApiServices
import com.suhov.aaspc2023.data.stores.SessionStore
import com.suhov.aaspc2023.data.utils.DispatchersProject
import com.suhov.aaspc2023.data.utils.TimeConstants.SECOND
import com.suhov.aaspc2023.ui.screens.core.LoadingState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.annotation.Single

@Single
class GetRepos(
	private val dispatchers: DispatchersProject,
	private val sessionStore: SessionStore,
	private val apiServices: ApiServices,
){

	private var getRepoJob: Job? = null

	operator fun invoke(duration: Long = SECOND) {
		getRepoJob?.cancel()
		getRepoJob = dispatchers.ioScope.launch {
			sessionStore.setLoading(LoadingState.Loading)
			delay(duration)
			val reposResult = apiServices.gitHubApi.getGitRepo()
			when {
				reposResult.isSuccessful -> {
					val data = reposResult.body() ?: return@launch
					sessionStore.setRepos(data)
				}
				!reposResult.isSuccessful -> {
					val message = reposResult.errorBody().toString()
					sessionStore.setLoading(LoadingState.Error(message))
				}
			}
			sessionStore.setLoading(LoadingState.Finished)

		}
	}

}
