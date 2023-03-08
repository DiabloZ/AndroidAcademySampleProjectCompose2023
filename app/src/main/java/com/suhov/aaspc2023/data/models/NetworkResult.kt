package com.suhov.aaspc2023.data.models

sealed class NetworkResult <out T: Any> {
	data class Success<out T: Any>(val data: T, val answerCode: Int? = null): NetworkResult<T>()
	data class Error(val error: ServerException): NetworkResult<Nothing>()
}
