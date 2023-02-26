package com.suhov.aaspc2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.suhov.aaspc2023.ui.components.previews.PhonePreview
import com.suhov.aaspc2023.ui.components.screens.errorloaddata.ErrorScreen
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
					ErrorScreen(
						onLinkClick = {
							Timber.w("!!!!!!!!!! onLinkClick - $it")
						},
						onRefreshButtonClick = {
							Timber.w("!!!!!!!!!! onClick - RefreshButton")
						},
						modifier = Modifier
					)
				}
			}
		}
	}
}

@PhonePreview
@Composable
fun DefaultPreview() {
	AndroidAcademySampleProjectCompose2023Theme {
		ErrorScreen(
			onLinkClick = {},
			onRefreshButtonClick = {},
			modifier = Modifier
		)
	}
}