package com.suhov.aaspc2023.ui.components.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.suhov.aaspc2023.R
import com.suhov.aaspc2023.ui.components.previews.ElementPreview
import com.suhov.aaspc2023.ui.components.previews.PhonePreview

@ElementPreview
@PhonePreview
@Composable
fun PreviewItemGithubRepoList() {
	ItemGithubRepoList (
		link = "https://www.pngaaa.com/api-download/3018884",
		title = "Test",
		subTitle = "SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest SubtitleTest ",
	)
}

@Composable
fun ItemGithubRepoList(
	link: String,
	title: String,
	subTitle: String,
	modifier: Modifier = Modifier,
	alignment: Alignment = Alignment.Center
) {

	Row(
		modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
	){
		AsyncImage(
			model = link,
			contentDescription = null,
			alignment = alignment,
			placeholder = painterResource(R.drawable.ic_sad_cat),
			contentScale = ContentScale.Crop,
			modifier = modifier
				.padding(top = 4.dp)
				.widthIn(max = 56.dp)
				.aspectRatio(1f / 1f)
				.clip(RoundedCornerShape(percent = 25))

		)

		Spacer(modifier = Modifier.padding(horizontal = 8.dp))

		Column(
			modifier = modifier.weight(1f).alignByBaseline()
		) {
			Text(
				text = title,
				style = MaterialTheme.typography.titleLarge.injectZeroFontPaddings(),
				textAlign = TextAlign.Start,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
			)
			Text(
				text = subTitle,
				style = MaterialTheme.typography.titleSmall.injectZeroFontPaddings(),
				textAlign = TextAlign.Start,
				fontWeight = FontWeight.Normal,
				modifier = Modifier
			)
		}

	}
	
}

fun TextStyle.injectZeroFontPaddings() = copy(
	platformStyle = PlatformTextStyle(
		includeFontPadding = false
	),
	lineHeightStyle = LineHeightStyle(
		alignment = LineHeightStyle.Alignment.Proportional,
		trim = LineHeightStyle.Trim.Both
	)
)
