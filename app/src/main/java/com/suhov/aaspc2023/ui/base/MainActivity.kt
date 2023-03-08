package com.suhov.aaspc2023.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.screens.errorloaddata.ErrorScreen
import com.suhov.aaspc2023.ui.screens.errorloaddata.ErrorScreenIntent
import com.suhov.aaspc2023.ui.screens.errorloaddata.ErrorScreenState
import com.suhov.aaspc2023.ui.screens.errorloaddata.ErrorViewModel
import com.suhov.aaspc2023.ui.theme.AndroidAcademySampleProjectCompose2023Theme
import com.suhov.aaspc2023.ui.util.navigation.Screen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : ComponentActivity() {


	private val viewModel: MainActivityViewModel by viewModel()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


		lifecycleScope.launch {
			viewModel.gitHubRepoData.collect { repos ->
				Timber.e("MAIN ACTIVITY TEST - $repos")
			}
		}
		setContent {
			AndroidAcademySampleProjectCompose2023Theme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
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
							val vm: ErrorViewModel = koinViewModel()
							ErrorScreen(
								state = vm.state.collectAsStateWithLifecycle(),
								onLinkClick = { link ->
									vm.pushIntent(ErrorScreenIntent.clickOnLink(link))
								},
								onRefreshButtonClick = {
									val navOption = NavOptions.Builder()
										.setEnterAnim( R.anim.slide_in_left )
										.setExitAnim( R.anim.slide_out_left )
										.setPopEnterAnim( R.anim.slide_in_left )
										.setPopExitAnim( R.anim.slide_out_left )
										.build()


									vm.pushIntent(ErrorScreenIntent.clickOnRefresh)
									navController.navigate(
										route = Screen.GithubReposScreen.route,
									 	navOptions = navOption
									)
								},
								modifier = Modifier
							)
						}
						composable(route = Screen.GithubReposScreen.route){
							val vm: ErrorViewModel = koinViewModel()
								
								ErrorScreen(
									state = vm.state.collectAsStateWithLifecycle(),
									onLinkClick = { link ->
										vm.pushIntent(ErrorScreenIntent.clickOnLink(link))
									},
									onRefreshButtonClick = {
										vm.pushIntent(ErrorScreenIntent.clickOnRefresh)
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
			state = remember{mutableStateOf(ErrorScreenState.initializeState)},
			onLinkClick = {},
			onRefreshButtonClick = {},
			modifier = Modifier
		)
	}
}