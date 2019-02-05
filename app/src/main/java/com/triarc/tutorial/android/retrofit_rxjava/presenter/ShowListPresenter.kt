package com.triarc.tutorial.android.retrofit_rxjava.presenter

import com.triarc.tutorial.android.retrofit_rxjava.base.AbstractBasePresenter
import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList

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

            if(shows != null) {
                getView()?.onTvShowReceived(shows)
            } else {
                getView()?.onError("List is empty")
            }
        }, {
            getView()?.onStopProgress()

            getView()?.onError("Something went wrong")
        }))
    }
}
