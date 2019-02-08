package com.triarc.tutorial.android.retrofit_rxjava.dto

/**
 * Created by Devanshu Verma on 8/2/19
 */
class Error(var code: Int? = null, message: String? = null, cause: Throwable? = null): Throwable(message, cause)
