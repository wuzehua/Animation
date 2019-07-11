package com.example.animationdemo

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rank_card_view.view.*

class RankViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var items = ArrayList<RankData>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TEXT_ONLY)
            RankViewHolder.create(viewGroup.context,viewGroup)
        else {
            RankCardViewHolder.create(viewGroup.context,viewGroup)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items.get(position).getViewType() == TEXT_ONLY) {
            (holder as RankViewHolder).bind(items.get(position), position)
        }
        else
        {
            (holder as RankCardViewHolder).bind(items.get(position), position)
            holder.view.favorite.setOnClickListener(object: View.OnClickListener
            {
                override fun onClick(view: View?) {
                    val data = items.get(position)
                    if (data.getFavourite())
                    {
                        view?.favorite?.speed = -2.0f
                    }
                    else
                    {
                        view?.favorite?.speed = 2.0f
                    }
                    view?.favorite?.playAnimation()
                    data.setFavorite(!data.getFavourite())
                    println("${position} clicked and ${data.getFavourite()}")
                    //Log.println(Log.INFO,null,"${position} clicked and ${data.getFavourite()}")
                }
            })

            holder.view.cv_card.setOnClickListener(object: View.OnClickListener
            {
                override fun onClick(view: View?) {
                    println("Click")
                }
            })
        }
    }


    fun setData(data: ArrayList<RankData>)
    {
        items = data
    }

    fun insertData(index: Int,data: RankData?)
    {
        if(data == null || index < 0 || index > items.size)
            return

        items.add(index,data)
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).getViewType()
    }

    fun getData(index: Int): RankData?
    {
        if(index < 0 || index >= items.size)
            return null

        return items[index]
    }

}