package com.suhov.aaspc2023.ui.components.screens.errorloaddata

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.buttons.RefreshButton
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.components.screens.errorloaddata.parts.ContentErrorScreen

@PhonePreview
@Composable
private fun ErrorScreenPreview(){
	ErrorScreen(
		onLinkClick = {},
		onRefreshButtonClick = {},
		modifier = Modifier
	)
}

@Composable
fun ErrorScreen(
	onLinkClick: (link: String) -> Unit,
	onRefreshButtonClick: () -> Unit,
	modifier: Modifier = Modifier,
){
	Column(
		modifier = modifier.fillMaxSize(),
	) {
		ContentErrorScreen(
			onLinkClick = onLinkClick,
			Modifier.padding(16.dp)
				.align(Alignment.CenterHorizontally)
				.weight(1f)
		)

		RefreshButton(
			text = "To try load the data",
			onClick = onRefreshButtonClick,
			rightIconRes = R.drawable.ic_refresh,
			rightIconDescription = null,
			backgroundColor = MaterialTheme.colors.secondary,
			contentColor = Color.Yellow,
			spacerValue = 16.dp,
			shape = 50.dp,
			modifier = Modifier.fillMaxWidth()
				.padding(horizontal = 16.dp, vertical = 24.dp)
		)
	}
}