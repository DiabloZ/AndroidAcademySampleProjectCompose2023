package com.suhov.aaspc2023.ui.screens.errorloaddata

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.buttons.RefreshButton
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.screens.errorloaddata.parts.ContentErrorScreen

@PhonePreview
@Composable
private fun ErrorScreenPreview(){
	ErrorScreen(
		modifier = Modifier,
		state = remember{ mutableStateOf(ErrorScreenState.initializeState) },
		onLinkClick = {},
		onRefreshButtonClick = {},
	)
}

@Composable
fun ErrorScreen(
	state: State<ErrorScreenState>,
	onLinkClick: (link: String) -> Unit,
	onRefreshButtonClick: () -> Unit,
	modifier: Modifier = Modifier,
){
	val value by remember { state }
	Column(
		modifier = modifier.fillMaxSize(),
	) {
		ContentErrorScreen(
			onLinkClick = onLinkClick,
			Modifier
				.padding(16.dp)
				.align(Alignment.CenterHorizontally)
				.weight(1f)
		)

		RefreshButton(
			text = value.textLoadButton,
			onClick = onRefreshButtonClick,
			rightIconRes = R.drawable.ic_refresh,
			rightIconDescription = null,
			backgroundColor = MaterialTheme.colors.secondary,
			contentColor = Color.Yellow,
			spacerValue = 16.dp,
			shape = 50.dp,
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp, vertical = 24.dp)
		)
	}
}