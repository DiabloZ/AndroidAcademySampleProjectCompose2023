package com.suhov.aaspc2023.ui.screens.gitrepolist
import com.suhov.aaspc2023.domain.models.GitHubUserItem

data class GithubUsersListState(
	val isLoading: Boolean,
	val usersList: List<GitHubUserItem>?,
	val isError: Boolean
) {
	companion object {
		val initializeState = GithubUsersListState(
			isLoading = true,
			usersList = listOf(),
			isError = false
		)
	}
}
