package com.suhov.aaspc2023.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.components.screens.errorloaddata.ErrorScreen
import com.suhov.aaspc2023.ui.theme.AndroidAcademySampleProjectCompose2023Theme
import com.suhov.aaspc2023.ui.util.navigation.Screen
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : ComponentActivity() {


	private val viewModel: MainActivityViewModel by viewModel()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED){
				viewModel.getRepos()
				viewModel.gitHubRepoData.collect { repos ->
					Timber.e("MAIN ACTIVITY TEST - $repos")
				}
			}
		}
		setContent {
			AndroidAcademySampleProjectCompose2023Theme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
/*					val testViewModel: MainActivityViewModel = viewModel()
					testViewModel.getRepos()*/
					val navController = rememberNavController()
					navController.addOnDestinationChangedListener{
							controller,
							destination,
							arguments ->
						Timber.e("POSITION - controller - $controller, destination - $destination, arguments - $arguments")
					}
					NavHost(
						navController = navController,
						startDestination = Screen.ErrorScreen.route
					){
						composable(route = Screen.ErrorScreen.route){
							ErrorScreen(
								onLinkClick = {
									Timber.w("!!!!!!!!!! onLinkClick - $it")
								},
								onRefreshButtonClick = {
									navController.navigate(Screen.GithubReposScreen.route)
									Timber.w("!!!!!!!!!! onClick - RefreshButton")
								},
								modifier = Modifier
							)
						}
						composable(route = Screen.GithubReposScreen.route){
							ErrorScreen(
								onLinkClick = {
									Timber.w("!!!!!!!!!! GithubReposScreen onLinkClick - $it")
								},
								onRefreshButtonClick = {
									Timber.w("!!!!!!!!!! GithubReposScreen onClick - RefreshButton")
								},
								modifier = Modifier
							)
						}
					}

				}
			}
		}
	}
}

@PhonePreview
@Composable
fun DefaultPreview() {
	AndroidAcademySampleProjectCompose2023Theme {
		ErrorScreen(
			onLinkClick = {},
			onRefreshButtonClick = {},
			modifier = Modifier
		)
	}
}