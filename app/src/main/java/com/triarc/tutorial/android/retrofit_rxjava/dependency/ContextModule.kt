package com.triarc.tutorial.android.retrofit_rxjava.dependency

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 8/2/19
 */
@Module
class ContextModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideBaseContext(): Context = application.baseContext

    @Provides
    @Singleton
    fun provideApplication(): Application = application
}
