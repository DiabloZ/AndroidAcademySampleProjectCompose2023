package com.suhov.aaspc2023.ui.screens.errorloaddata

sealed interface ErrorScreenIntent {
	object clickOnRefresh: ErrorScreenIntent
	class clickOnLink(val link: String): ErrorScreenIntent

}