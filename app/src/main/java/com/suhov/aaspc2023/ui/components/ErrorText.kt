package com.suhov.aaspc2023.ui.components

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@ElementPreview
@Composable
private fun ErrorWarningTextPreview(){
	ErrorWarningText(
		text = "Something went wrong"
	)
}

@Composable
fun ErrorWarningText(
	text: String,
	modifier: Modifier = Modifier,
) {
	Text(
		text = text,
		style = MaterialTheme.typography.bodyLarge,
		textAlign = TextAlign.Center,
		fontWeight = FontWeight.Bold,
		modifier = modifier,
	)

}