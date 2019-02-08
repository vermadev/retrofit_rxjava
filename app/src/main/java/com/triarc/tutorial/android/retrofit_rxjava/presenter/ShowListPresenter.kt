package com.triarc.tutorial.android.retrofit_rxjava.presenter

import com.triarc.tutorial.android.retrofit_rxjava.base.AbstractBasePresenter
import com.triarc.tutorial.android.retrofit_rxjava.common.ErrorCode
import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList
import com.triarc.tutorial.android.retrofit_rxjava.dto.Error

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowListPresenter(private val model: ShowList.Model): AbstractBasePresenter<ShowList.View>(), ShowList.Presenter {

    override fun attachView(view: ShowList.View) {
        super.attachView(view)
        view.onInitialiseListLayout()
        view.onInitialiseAdapter()
    }

    override fun requestTvShowList() {
        getView()?.onShowProgress()
        subscription.add(model.getTvShowList().subscribe({shows ->
            getView()?.onStopProgress()
            getView()?.onTvShowReceived(shows)
        }, {
            getView()?.onStopProgress()

            val error = it as Error
                val message = when(error.code) {
                    ErrorCode.NULL_RESPONSE -> "List is empty"
                    ErrorCode.INTERNET_NOT_AVAILABLE -> "Internet not available"
                    else -> "Something went wrong"
                }
                getView()?.onError(message)
        }))
    }
}
