package com.suhov.aaspc2023.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.previews.ElementPreview

@ElementPreview
@Composable
fun RefreshButtonPreview(){
	RefreshButton(
		text = "Some button",
		onClick = {},
		leftIconRes = R.drawable.ic_refresh,
		leftIconDescription = null,
		rightIconRes = R.drawable.ic_refresh,
		rightIconDescription = null,
		contentColor = Color.Yellow,
		backgroundColor = Color.Cyan,
		modifier = Modifier,
		spacerValue = 21.dp
	)
}

@Composable
fun RefreshButton(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	@DrawableRes leftIconRes: Int? = null,
	leftIconDescription: String? = null,
	@DrawableRes rightIconRes: Int? = null,
	rightIconDescription: String? = null,
	spacerValue: Dp = 8.dp,
	contentColor: Color = Color.Yellow,
	backgroundColor: Color = Color.Cyan
){
	Button(
		onClick = onClick,
		modifier = modifier,
		shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp),
		contentPadding = PaddingValues(8.dp),
		colors = ButtonDefaults.buttonColors(
			backgroundColor = backgroundColor,
			contentColor = contentColor
		)
	) {
		LeftIcon(leftIconRes, leftIconDescription, spacerValue)
		Text(
			text = text,
			style = MaterialTheme.typography.headlineSmall,
			textAlign = TextAlign.Center,
			fontWeight = FontWeight.Bold,
		)
		RightIcon(rightIconRes, rightIconDescription, spacerValue)
	}

}

@Composable
private fun RightIcon(rightIconRes: Int?, rightIconDescription: String?, spacerValue: Dp) {
	rightIconRes ?: return
	Spacer(modifier = Modifier.padding(start = spacerValue))
	Icon(painter = painterResource(id = rightIconRes), contentDescription = rightIconDescription)
}

@Composable
private fun LeftIcon(leftIconRes: Int?, leftIconDescription: String?, spacerValue: Dp) {
	leftIconRes ?: return
	Icon(painter = painterResource(id = leftIconRes), contentDescription = leftIconDescription)
	Spacer(modifier = Modifier.padding(end = spacerValue))
}