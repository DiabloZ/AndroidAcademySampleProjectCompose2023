package com.suhov.aaspc2023.ui.components

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

@ElementPreview
@Composable
private fun ErrorCodeTextPreview(){
	ErrorCodeText(
		text = "Error code",
		errorCode = "BB-404"
	)
}

@Composable
fun ErrorCodeText(
	text: String,
	errorCode: String,
	modifier: Modifier = Modifier,
) {
	val fullText = buildAnnotatedString {
		append(text)
		append(spacerWithColonString)
		withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
			append(errorCode)
		}
/*
		Other way of create other style in the string -
		pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
		append(errorCode)
		pop()*/
	}
	Text(
		text = fullText,
		style = MaterialTheme.typography.bodySmall,
		textAlign = TextAlign.Center,
		fontWeight = FontWeight.Normal,
		modifier = modifier,
	)

}

const val spacerString = " "
const val spacerWithColonString = ": "
const val spacerWithCommaString = ", "
const val spacerWithCommaAndLineFeedString = ","