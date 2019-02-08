package com.triarc.tutorial.android.retrofit_rxjava.application

import android.app.Application
import com.triarc.tutorial.android.retrofit_rxjava.dependency.ApplicationComponent
import com.triarc.tutorial.android.retrofit_rxjava.dependency.DaggerApplicationComponent
import com.triarc.tutorial.android.retrofit_rxjava.dependency.RetrofitServiceModule
import com.triarc.tutorial.android.retrofit_rxjava.dependency.ShowListModule
import com.triarc.tutorial.android.retrofit_rxjava.intf.Logger
import com.triarc.tutorial.android.retrofit_rxjava.logger.LoggerImpl

/**
 * Created by Devanshu Verma on 5/2/19
 */
class RetroftRxJavaTutorialApplication: Application() {

    private val logger: Logger = LoggerImpl.getLogger(this)

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .showListModule(ShowListModule())
            .retrofitServiceModule(RetrofitServiceModule())
            .build()

        logger.debug("HomeTime Application class created")
    }

    fun getApplicationComponent() = applicationComponent
}