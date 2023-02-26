package com.suhov.aaspc2023.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.previews.PhonePreview

@PhonePreview
@Composable
private fun ErrorImagePreview(

){
	ErrorImage(
		link = "https://www.pngaaa.com/api-download/3018884"
	)
}



@Composable
fun ErrorImage(
	link: String,
	modifier: Modifier = Modifier,
	errorColor: Color = Color.Red,
	alignment: Alignment = Alignment.Center
){
	AsyncImage(
		model = link,
		contentDescription = null,
		alignment = alignment,
		placeholder = painterResource(R.drawable.ic_sad_cat),
		contentScale = ContentScale.Crop,
		modifier = modifier.fillMaxWidth(0.5f)
			.aspectRatio(1f/1f)
			.clip(RoundedCornerShape(percent = 25))
			.border(
				BorderStroke(
					width = 8.dp,
					color = errorColor
				),
				RoundedCornerShape(percent = 25)
			),
	)
}

