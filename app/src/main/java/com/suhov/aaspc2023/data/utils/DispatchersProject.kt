package com.suhov.aaspc2023.data.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.annotation.Single

@Single
class DispatchersProject {

	val uiScope: CoroutineScope by lazy { CoroutineScope( Dispatchers.Main.immediate) }
	val computationScope: CoroutineScope by lazy { CoroutineScope( Dispatchers.Default + SupervisorJob()) }
	val ioScope: CoroutineScope by lazy { CoroutineScope( Dispatchers.IO + SupervisorJob()) }

}