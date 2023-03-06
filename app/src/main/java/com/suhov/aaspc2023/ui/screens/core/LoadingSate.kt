package com.suhov.aaspc2023.ui.screens.core

sealed class LoadingSate {
	object Default: LoadingSate()
	object Finished: LoadingSate()
	object Loading: LoadingSate()
	class Error(message:String): LoadingSate()
}

fun LoadingSate.isLoading() = when(this){
	LoadingSate.Default,
	is LoadingSate.Error,
	LoadingSate.Finished -> false
	LoadingSate.Loading -> true
}