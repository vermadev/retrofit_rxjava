package com.triarc.tutorial.android.retrofit_rxjava.repository

import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList
import com.triarc.tutorial.android.retrofit_rxjava.dto.Show
import com.triarc.tutorial.android.retrofit_rxjava.intf.MazeShowApi
import com.triarc.tutorial.android.retrofit_rxjava.intf.NetworkHandler
import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowListRepository(private val network: NetworkHandler, private val api: MazeShowApi): ShowList.Repository {

    override fun getTvShowList(): Observable<List<Show>> = network.request(api.getShowList())
}
