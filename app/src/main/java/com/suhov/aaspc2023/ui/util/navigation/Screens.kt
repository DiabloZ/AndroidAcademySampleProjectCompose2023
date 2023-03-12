package com.suhov.aaspc2023.ui.util.navigation

sealed class Screen(val route: String){

	object ErrorScreen: Screen("error_screen")

	object GithubUsersScreen: Screen("github_users_screen")
	
}
