package com.suhov.aaspc2023.ui.components.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider

class RatingPrams: PreviewParameterProvider<Int>{
	override val values: Sequence<Int>
		get() = (0..5).asSequence()

}
class OtherRatingPrams: CollectionPreviewParameterProvider<Int>((0..5).toList())

@Preview
@Composable
private fun RatingPreview(
	@PreviewParameter (OtherRatingPrams::class)
	rating: Int
){
	RatingView(rating = rating)
}

@Composable
internal fun RatingView(
	modifier: Modifier = Modifier,
	rating: Int,
	maxRating: Int = 5,
	onRatingChange: (newRating: Int) -> Unit = {}
) {
	Row(modifier = modifier){
		repeat(maxRating){
			Icon(
				imageVector = when {
					it < rating -> Icons.Filled.Star
					else ->  Icons.Filled.StarOutline
				},
				contentDescription = null
			)
		}
	}
}