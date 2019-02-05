package com.triarc.tutorial.android.retrofit_rxjava.base

/**
 * Created by Devanshu Verma on 5/2/19
 */
interface BasePresenter <View> {
    fun getView(): View?
    fun detachView()
    fun attachView(view: View)
}
