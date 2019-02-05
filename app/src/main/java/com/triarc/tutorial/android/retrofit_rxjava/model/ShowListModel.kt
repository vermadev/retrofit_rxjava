package com.triarc.tutorial.android.retrofit_rxjava.model

import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList
import com.triarc.tutorial.android.retrofit_rxjava.dto.Show
import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowListModel(private val repository: ShowList.Repository): ShowList.Model {

    override fun getTvShowList(): Observable<List<Show>> = repository.getTvShowList()
}
