package com.triarc.tutorial.android.retrofit_rxjava.base

import android.content.Context
import android.support.v4.app.FragmentActivity

/**
 * Created by Devanshu Verma on 5/2/19
 */
interface BaseView {
    fun getContext(): Context?
    fun getActivity(): FragmentActivity?
}
