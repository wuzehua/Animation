package com.example.animationdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentDemoPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm)
{

    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun setFragments(fragments: ArrayList<Fragment>)
    {
        this.fragments = fragments
    }

    fun setPageTitles(data: ArrayList<String>)
    {
        titles = data
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}