package com.triarc.tutorial.android.retrofit_rxjava.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.triarc.tutorial.android.retrofit_rxjava.MainActivity
import com.triarc.tutorial.android.retrofit_rxjava.R
import com.triarc.tutorial.android.retrofit_rxjava.adapter.ShowListAdapter
import com.triarc.tutorial.android.retrofit_rxjava.application.RetroftRxJavaTutorialApplication
import com.triarc.tutorial.android.retrofit_rxjava.contract.ShowList
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowListFragment: Fragment(), ShowList.View {

    private var rootView: View? = null

    private var showListAdapter: ShowListAdapter? = null

    private var recyclerLayoutManager: RecyclerView.LayoutManager? = null

    @Inject
    lateinit var presenter: ShowList.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ((activity as? MainActivity)?.application as? RetroftRxJavaTutorialApplication)?.getApplicationComponent()?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.attachView(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.requestTvShowList()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.detachView()
    }

    override fun onError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onShowProgress() {
        swipe_container.isRefreshing = true
    }

    override fun onStopProgress() {
        swipe_container.isRefreshing = false
    }

    override fun onTvShowReceived(shows: List<Any>) {
        showListAdapter?.updateList(shows)
    }

    override fun onInitialiseAdapter() {
        showListAdapter = ShowListAdapter(context)
        recycler_list_view.adapter = showListAdapter
    }

    override fun onInitialiseListLayout() {
        swipe_container.isEnabled = false

        recyclerLayoutManager = LinearLayoutManager(context)
        recycler_list_view.layoutManager = recyclerLayoutManager
    }
}
