package com.triarc.tutorial.android.retrofit_rxjava.intf

import com.triarc.tutorial.android.retrofit_rxjava.common.EndPoints
import com.triarc.tutorial.android.retrofit_rxjava.dto.Show
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Devanshu Verma on 5/2/19
 */
interface MazeShowApi {

    @GET(EndPoints.SHOWS)
    fun getShowList(): Observable<List<Show>>
}
