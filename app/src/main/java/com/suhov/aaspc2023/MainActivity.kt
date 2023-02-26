package com.suhov.aaspc2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.components.screens.errorloaddata.ErrorScreen
import com.suhov.aaspc2023.ui.theme.AndroidAcademySampleProjectCompose2023Theme
import com.suhov.aaspc2023.ui.util.navigation.Screen
import timber.log.Timber

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
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