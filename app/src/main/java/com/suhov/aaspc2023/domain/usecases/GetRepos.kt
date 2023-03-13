package com.suhov.aaspc2023.domain.usecases

import com.suhov.aaspc2023.data.models.NetworkResult
import com.suhov.aaspc2023.data.services.ApiServices
import com.suhov.aaspc2023.data.stores.SessionStore
import com.suhov.aaspc2023.data.utils.DispatchersProject
import com.suhov.aaspc2023.data.utils.network.NetworkHandler
import com.suhov.aaspc2023.data.utils.TimeConstants.SECOND
import com.suhov.aaspc2023.ui.screens.core.LoadingState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.annotation.Single
import timber.log.Timber

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

			when (
				val repoListCall = NetworkHandler.call { apiServices.gitHubApi.getGitRepo() }
			){
				is NetworkResult.Success -> sessionStore.setRepos(repoListCall.data)
				is NetworkResult.Error -> {
					errorInterceptor(repoListCall)
					sessionStore.setLoading(LoadingState.Error(repoListCall.error.exceptionMessage))
				}
			}

			sessionStore.setLoading(LoadingState.Finished)

		}
	}

	val errorInterceptor:(NetworkResult.Error) -> Unit = { error ->
		Timber.e("Error code - ${error.error.code}, message - ${error.error.exceptionMessage}")
	}

}
