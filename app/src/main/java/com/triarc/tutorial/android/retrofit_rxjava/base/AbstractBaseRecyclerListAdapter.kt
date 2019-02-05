package com.triarc.tutorial.android.retrofit_rxjava.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.triarc.tutorial.android.retrofit_rxjava.intf.Logger
import com.triarc.tutorial.android.retrofit_rxjava.logger.LoggerImpl

/**
 * Created by Devanshu Verma on 5/2/19
 */
abstract class AbstractBaseRecyclerListAdapter<ViewHolder: AbstractBaseViewHolder>(protected var context: Context? = null): RecyclerView.Adapter<ViewHolder>() {

    protected val logger: Logger = LoggerImpl.getLogger(this)

    companion object ViewType {
        const val ITEM   = 1
        const val FOOTER = 2
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder

    abstract fun updateList(list: List<Any>?)

    abstract fun getItem(position: Int): Any?

    abstract override fun getItemCount(): Int

    abstract override fun getItemViewType(position: Int): Int

    abstract override fun onBindViewHolder(viewHolder: ViewHolder, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return getViewHolder(parent, viewType)
    }
}
