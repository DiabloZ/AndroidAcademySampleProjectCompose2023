package com.suhov.aaspc2023.base

import android.app.Application
import com.suhov.aaspc2023.BuildConfig
import timber.log.Timber

class App: Application() {
	override fun onCreate() {
		super.onCreate()
		initTimber()
	}

	private fun initTimber() {
		if (BuildConfig.DEBUG)
			Timber.plant(Timber.DebugTree())
	}
}