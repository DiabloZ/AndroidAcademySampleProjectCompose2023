package com.suhov.aaspc2023.ui.screens.errorloaddata

data class ErrorScreenState (
	val isLoading: Boolean,
	val textLoadButton: String
){
	companion object {
		val initializeState = ErrorScreenState(
			isLoading = false,
			textLoadButton = "To try load the data"
		)
	}
}