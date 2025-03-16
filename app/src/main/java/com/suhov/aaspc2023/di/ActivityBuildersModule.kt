package com.suhov.aaspc2023.di

import dagger.Module
import dagger.Provides

@Module
class ActivityBuildersModule {


	@Provides
	fun someString() = "lalala!"

}