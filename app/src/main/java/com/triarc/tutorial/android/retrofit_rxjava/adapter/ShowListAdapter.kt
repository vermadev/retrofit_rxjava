package com.triarc.tutorial.android.retrofit_rxjava.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.triarc.tutorial.android.retrofit_rxjava.R
import com.triarc.tutorial.android.retrofit_rxjava.adapter.viewholder.ShowItemViewHolder
import com.triarc.tutorial.android.retrofit_rxjava.base.AbstractBaseRecyclerListAdapter
import com.triarc.tutorial.android.retrofit_rxjava.dto.Show
import com.triarc.tutorial.android.retrofit_rxjava.utility.Utils

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowListAdapter(context: Context?, private var shows: List<Show>? = null) : AbstractBaseRecyclerListAdapter<ShowItemViewHolder>(context) {

    private val picasso: Picasso = Picasso.with(context)

    override fun getItem(position: Int): Show? = shows?.get(position)

    @Suppress("UNCHECKED_CAST")
    override fun updateList(list: List<Any>?) {
        shows = if(!list.isNullOrEmpty()) {
            list as List<Show>
        }
        else {
            null
        }

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = shows?.size ?: 0

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ShowItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_show, parent, false)
        return ShowItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = if (shows?.get(position) != null) ITEM else FOOTER

    override fun onBindViewHolder(viewHolder: ShowItemViewHolder, position: Int) {
        var show: Show? = null

        if(!shows.isNullOrEmpty()) {
            show = shows!![position]
        }

        show?.let {
            with(it){
                val subtitle = Utils.getSchedule(Utils.getPrefix(schedule?.time), Utils.getDayDescriptor(schedule?.days), Utils.getTimeDescriptor(schedule?.time))
                logger.debug("Subtitle: '$subtitle'")

                viewHolder.title.text    = name
                viewHolder.subTitle.text = subtitle

                viewHolder.year.text   = show.premiered.split("-")[0]
                viewHolder.genre.text  = show.genres?.joinToString(", ")
                viewHolder.rating.text = "Average Rating ${show.rating?.average}"

                picasso.load(image?.original).into(viewHolder.image)
            }
        }
    }
}
