package com.suhov.aaspc2023.ui.util.navigation

sealed class Screen(val route: String){

	object ErrorScreen: Screen("error_screen")

	object GithubReposScreen: Screen("github_repos_screen")
	
}
