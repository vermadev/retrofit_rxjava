package com.triarc.tutorial.android.retrofit_rxjava.dto

import java.io.Serializable

/**
 * Created by Devanshu Verma on 5/2/19
 */
data class Show(var name: String?,
                var image: Image?,
                var schedule: Schedule?,
                var genres: List<String>?,
                var premiered: String,
                var rating: Rating?): Serializable
