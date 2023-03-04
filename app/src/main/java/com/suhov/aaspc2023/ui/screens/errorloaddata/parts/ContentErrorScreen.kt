package com.suhov.aaspc2023.ui.screens.errorloaddata.parts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.suhov.aaspc2023.ui.components.ClickableSmallText
import com.suhov.aaspc2023.ui.components.ErrorCodeText
import com.suhov.aaspc2023.ui.components.ErrorImage
import com.suhov.aaspc2023.ui.components.ErrorWarningText
import com.suhov.aaspc2023.ui.components.previews.ElementPreview
import com.suhov.aaspc2023.ui.components.previews.PhonePreview

@ElementPreview
@Composable
private fun ContentErrorScreenPreviewElement() {
	ContentErrorScreen(
		onLinkClick = {},
		Modifier.padding(16.dp),
	)
}

@PhonePreview
@Composable
private fun ContentErrorScreenPreviewPhone() {
	ContentErrorScreen(
		onLinkClick = {},
	)
}

@Composable
fun ContentErrorScreen(
	onLinkClick: (link: String) -> Unit,
	modifier: Modifier = Modifier,
) {
	Column(
		modifier,
		verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
		horizontalAlignment = Alignment.CenterHorizontally,
		//content = {}
	) {
		ErrorImage( link = "https://www.pngaaa.com/api-download/3018884" )
		ErrorWarningText(text = "Whoops, we couldn't load the data!")
		ErrorCodeText(
			text = "Error code",
			errorCode = "BB-404"
		)
		ClickableSmallText(
			text = "Something went wrong,\n",
			clickableText = "please tap on this link and we try to fix it.",
			linkForClick = "https://www.google.com",
			onTextClick = onLinkClick
		)
	}

}