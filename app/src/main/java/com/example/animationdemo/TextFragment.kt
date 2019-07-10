package com.example.animationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frame_layout.view.*

class TextFragment : Fragment()
{

    companion object
    {
        fun newInstance(text: String): TextFragment
        {
            val result = TextFragment()
            val args = Bundle()
            args.putString("content", text)
            result.arguments = args
            return result
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var text = "Fragment Demo"
        val args = arguments
        if(args != null)
        {
            text = args.getString("content","Fragment Demo")
        }

        val view = inflater.inflate(R.layout.frame_layout, container, false)
        view.tv_content.text = text
        return view

    }


}