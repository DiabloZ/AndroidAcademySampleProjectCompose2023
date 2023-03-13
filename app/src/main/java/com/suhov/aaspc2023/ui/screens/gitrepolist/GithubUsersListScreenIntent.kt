package com.suhov.aaspc2023.ui.screens.gitrepolist

sealed interface GithubUsersListScreenIntent {
	object Loading: GithubUsersListScreenIntent
	object GotError: GithubUsersListScreenIntent
	class ClickOnTheUser(val userId: Int): GithubUsersListScreenIntent
}