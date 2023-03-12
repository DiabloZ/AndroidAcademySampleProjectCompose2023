package com.suhov.aaspc2023.ui.screens.gitrepolist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.components.listelements.ItemGithubUser


@PhonePreview
@Composable
private fun PreviewGithubUsersList() {
	GithubUsersList(
		state = remember{ mutableStateOf(GithubUsersListState.initializeState) },
		modifier = Modifier
	)
}

@Composable
fun GithubUsersList(
	state: State<GithubUsersListState>,
	modifier: Modifier = Modifier,
) {
	val list by remember { state }
	val users = list.usersList ?: return
	LazyColumn(){
		items(
			items = users,
			itemContent = { gitHubUser ->
				ItemGithubUser(gitHubUser)
			}
		)
	}
}