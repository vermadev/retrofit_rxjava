package com.triarc.tutorial.android.retrofit_rxjava.contract

import com.triarc.tutorial.android.retrofit_rxjava.base.BasePresenter
import com.triarc.tutorial.android.retrofit_rxjava.base.BaseView
import com.triarc.tutorial.android.retrofit_rxjava.dto.Show
import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 5/2/19
 */
interface ShowList {

    interface View: BaseView {
        fun onError(message: String)
        fun onShowProgress()
        fun onStopProgress()
        fun onTvShowReceived(shows: List<Any>)
        fun onInitialiseAdapter()
        fun onInitialiseListLayout()    }

    interface Model {
        fun getTvShowList(): Observable<List<Show>>
    }

    interface Presenter: BasePresenter<View> {
        fun requestTvShowList()
    }

    interface Repository {
        fun getTvShowList(): Observable<List<Show>>
    }
}
