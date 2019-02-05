package com.triarc.tutorial.android.retrofit_rxjava.dependency

import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList
import com.triarc.tutorial.android.retrofit_rxjava.intf.MazeShowApi
import com.triarc.tutorial.android.retrofit_rxjava.model.ShowListModel
import com.triarc.tutorial.android.retrofit_rxjava.network.NetworkHandlerImpl
import com.triarc.tutorial.android.retrofit_rxjava.presenter.ShowListPresenter
import com.triarc.tutorial.android.retrofit_rxjava.repository.ShowListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 5/2/19
 */
@Module
class ShowListModule {

    @Provides
    @Singleton
    fun provideTvShowModel(repository: ShowList.Repository): ShowList.Model = ShowListModel(repository)

    @Provides
    @Singleton
    fun provideTvShowPresenter(model: ShowList.Model): ShowList.Presenter = ShowListPresenter(model)

    @Provides
    @Singleton
    fun provideTvShowRepository(network: NetworkHandlerImpl, api: MazeShowApi): ShowList.Repository = ShowListRepository(network, api)
}
