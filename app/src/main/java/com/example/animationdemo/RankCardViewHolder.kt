package com.example.animationdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import java.text.FieldPosition

class RankCardViewHolder (val view: View): RecyclerView.ViewHolder(view)
{
    private var mNoTextView: TextView
    private var mTitleTextView: TextView
    private var mTypeTextView: TextView
    private var mHotNumTextView: TextView
    private var favorite: LottieAnimationView
    private var mView: View

    init {
        mView = view
        mNoTextView = view.findViewById(R.id.tv_positionTextCard)
        mTitleTextView = view.findViewById(R.id.tv_titleTextCard)
        mTypeTextView = view.findViewById(R.id.tv_typeTextCard)
        mHotNumTextView = view.findViewById(R.id.tv_hotNumberCard)
        favorite = view.findViewById(R.id.favorite)
    }

    companion object
    {
        fun create(context: Context, root: ViewGroup): RankCardViewHolder {
            val v = LayoutInflater.from(context).inflate(R.layout.rank_card_view, root, false)
            return RankCardViewHolder(v)
        }
    }


    fun bind(data: RankData?, position: Int)
    {
        if (data == null)
            return

        if (position < 3)
        //mNoTextView.setTextColor(R.color.specialNoColor)
            mNoTextView.setTextColor(Color.parseColor("#e6face15"))
        else
            mNoTextView.setTextColor(Color.parseColor("#FF1F1F1F"))

        mNoTextView.text = "${position + 1}."
        if(data.getType() == Type.None)
        {
            mTypeTextView.text = ""
            mTypeTextView.setBackgroundColor(Color.TRANSPARENT)
        }
        else if(data.getType() == Type.Hot)
        {
            mTypeTextView.text = "热"
            mTypeTextView.setBackgroundColor(Color.parseColor("#B10511"))
        }
        else
        {
            mTypeTextView.text = "新"
            mTypeTextView.setBackgroundColor(Color.parseColor("#4C3283"))
        }

        mTitleTextView.text = data.getTitle()
        mHotNumTextView.text = data.getNumber().toString()


        if (data.getFavourite())
        {
            favorite.progress = 1.0F
        }
        else
        {
            favorite.progress = 0.0F
        }

    }

}