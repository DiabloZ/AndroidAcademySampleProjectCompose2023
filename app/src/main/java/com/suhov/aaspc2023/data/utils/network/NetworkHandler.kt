package com.suhov.aaspc2023.data.utils.network

import com.suhov.aaspc2023.data.models.NetworkResult
import com.suhov.aaspc2023.data.models.ServerException
import retrofit2.Response
import timber.log.Timber

object NetworkHandler: NetworkHandlerExtensions {

	private const val emptyBodyText = "Request could successful but body is null :("
	private const val emptyErrorText = "Error caused without message"

	suspend fun <T: Any> call(callBody: suspend () -> Response<T>): NetworkResult<T>{
		return try {
			val response = callBody.invoke()
			val isSuccessful = response.isSuccessful
			if (isSuccessful){
				val data = response.body() ?: return emptyBodyText.toErrorResult()
				NetworkResult.Success(data)
			} else {
				handleNullBody(response.raw())
			}
		} catch (e: Throwable) {
			Timber.e(e)
			val message = e.message ?: e.localizedMessage ?: emptyErrorText
			message.toErrorResult()
		}
	}

	private fun <T: Any> handleNullBody(raw: okhttp3.Response): NetworkResult<T> {
		return NetworkResult.Error(
			ServerException(raw.message, raw.code)
		)
	}

}