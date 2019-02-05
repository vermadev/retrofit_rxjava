package com.triarc.tutorial.android.retrofit_rxjava.dependency

import com.triarc.tutorial.android.retrofit_rxjava.view.ShowListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 5/2/19
 */
@Singleton
@Component(modules = [ShowListModule::class, RetrofitServiceModule::class])
interface ApplicationComponent {

    fun inject(target: ShowListFragment)
}
