package com.triarc.tutorial.android.retrofit_rxjava.intf

import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 5/2/19
 */
interface NetworkHandler {
    fun <Response> request(observable: Observable<Response>): Observable<Response>
}
