package com.suhov.aaspc2023.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.suhov.aaspc2023.ui.components.previews.ElementPreview

@ElementPreview
@Composable
private fun ErrorCodeTextPreview(){
	ClickableSmallText(
		text = "We can to fix it,\n",
		clickableText = "please tap on the link",
		linkForClick = "https://www.google.com",
		onTextClick = {

		}
	)
}

private const val defaultTagClickableSmallText = "clickableTag"

@OptIn(ExperimentalTextApi::class)
@Composable
fun ClickableSmallText(
	text: String,
	clickableText: String,
	linkForClick: String,
	onTextClick: (text:String) -> Unit,
	modifier: Modifier = Modifier,
) {
	val annotatedString = buildAnnotatedString {
		append(text)
		withStyle(
			SpanStyle(
				textDecoration = TextDecoration.Underline,
				color = Color.Blue
			)
		){
			withAnnotation(
				tag = defaultTagClickableSmallText,
				annotation = linkForClick
			){
				append(clickableText)
			}
		}
	}


	ClickableText(
		text = annotatedString,
		onClick = { offset ->
			val annotation = annotatedString
				.getStringAnnotations(defaultTagClickableSmallText, offset, offset)
				.firstOrNull() ?: return@ClickableText

			onTextClick(annotation.item)
		},
		style = TextStyle.Default.merge(
			TextStyle(textAlign = TextAlign.Center)
		),
		modifier = modifier,
	)

}