package com.triarc.tutorial.android.retrofit_rxjava.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.triarc.tutorial.android.retrofit_rxjava.R
import com.triarc.tutorial.android.retrofit_rxjava.base.AbstractBaseViewHolder

/**
 * Created by Devanshu Verma on 5/2/19
 */
class ShowItemViewHolder(view: View): AbstractBaseViewHolder(view){

    val image: ImageView = view.findViewById(R.id.cover_image)

    val year:     TextView = view.findViewById(R.id.year)
    val genre:    TextView = view.findViewById(R.id.genre)
    val title:    TextView = view.findViewById(R.id.title)
    val rating:   TextView = view.findViewById(R.id.rating)
    val subTitle: TextView = view.findViewById(R.id.subtitle)
}
