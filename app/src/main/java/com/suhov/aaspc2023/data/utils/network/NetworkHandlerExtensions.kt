package com.suhov.aaspc2023.data.utils.network

import com.suhov.aaspc2023.data.models.NetworkResult
import com.suhov.aaspc2023.data.models.ServerException

interface NetworkHandlerExtensions {
	fun String.toErrorResult() = NetworkResult.Error(
		ServerException(this)
	)
}