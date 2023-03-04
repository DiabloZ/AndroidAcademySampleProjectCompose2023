package com.suhov.aaspc2023.base

import android.app.Application
import com.suhov.aaspc2023.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule
import timber.log.Timber

class App: Application() {
	override fun onCreate() {
		super.onCreate()
		initTimber()
		initKoin()
	}



	private fun initTimber() {
		if (BuildConfig.DEBUG){
			Timber.plant(Timber.DebugTree())
		}
	}

	private fun initKoin() {
		startKoin {
			androidContext(this@App)
			modules(defaultModule)
			if (BuildConfig.DEBUG) {
				androidLogger()
			}
		}
	}
}