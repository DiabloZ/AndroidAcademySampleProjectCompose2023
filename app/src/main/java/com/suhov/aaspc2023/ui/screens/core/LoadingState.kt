package com.suhov.aaspc2023.ui.screens.core

sealed class LoadingState {
	object Default: LoadingState()
	object Finished: LoadingState()
	object Loading: LoadingState()
	class Error(message:String): LoadingState()
}

fun LoadingState.isLoading() = when(this){
	LoadingState.Default,
	is LoadingState.Error,
	LoadingState.Finished -> false
	LoadingState.Loading -> true
}