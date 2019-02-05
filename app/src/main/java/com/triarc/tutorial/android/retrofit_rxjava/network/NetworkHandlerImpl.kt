package com.triarc.tutorial.android.retrofit_rxjava.network

import com.triarc.tutorial.android.retrofit_rxjava.intf.NetworkHandler
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 5/2/19
 */
class NetworkHandlerImpl(private val observer: Scheduler, private val subscriber: Scheduler) : NetworkHandler {

    @Inject constructor(): this(AndroidSchedulers.mainThread(), Schedulers.io())

    override fun <Response> request(observable: Observable<Response>): Observable<Response> {
        return observable.subscribeOn(subscriber).observeOn(observer)
    }
}
