package com.suhov.aaspc2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suhov.aaspc2023.ui.components.ClickableSmallText
import com.suhov.aaspc2023.ui.components.ErrorImage
import com.suhov.aaspc2023.ui.theme.AndroidAcademySampleProjectCompose2023Theme
import timber.log.Timber

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidAcademySampleProjectCompose2023Theme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					Greeting("Android")
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String) {
	Column(
		modifier = Modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Hello $name!")
		ErrorImage(
			modifier = Modifier
				.fillMaxWidth(0.5f)
				.aspectRatio(1f / 1f)
				.clip(RoundedCornerShape(percent = 25))
				.border(
					BorderStroke(
						width = 8.dp,
						color = MaterialTheme.colorScheme.primary
					),
					RoundedCornerShape(percent = 25)
				)

		)

		Spacer(Modifier.padding(vertical = 20.dp))

		ClickableSmallText(
			text = "We can to fix it,\n",
			clickableText = "please tap on the link",
			linkForClick = "https://www.google.com",
			onTextClick = {
				Timber.w("!!!!!!!!!! - $it")
			}
		)
	}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	AndroidAcademySampleProjectCompose2023Theme {
		Greeting("Android")
	}
}