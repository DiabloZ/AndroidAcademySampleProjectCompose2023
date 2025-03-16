package com.suhov.aaspc2023.di

import android.content.Context
import com.suhov.aaspc2023.ui.base.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
	/*AndroidSupportInjectionModule::class,*/
	ActivityBuildersModule::class,
])
interface AppComponent/*: AndroidInjector<App>*/ {

	fun inject(activity: MainActivity)

	@Component.Factory
	interface Factory {
		fun create(@BindsInstance context: Context): AppComponent
	}

	/*@Component.Builder
	interface Builder {

		@BindsInstance
		fun application(application: Application): Builder

		fun build(): AppComponent
	}*/

}