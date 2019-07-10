package com.example.animationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_fragment_demo.*

class FragmentDemo : AppCompatActivity() {

    private val titles = arrayListOf("热搜榜","测试栏")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)

        val actionBar = supportActionBar

        if(actionBar != null)
        {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


        val fragmentLists = ArrayList<Fragment>()

        for(i in 0 until 2)
        {
            fragmentLists.add(RankListFragment())
        }

        tl_tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener
        {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                if(tab == null)
                    return
                vp_pageViewer.currentItem = tab.position
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
            }

        })

        val adapter = FragmentDemoPagerAdapter(supportFragmentManager)
        adapter.setFragments(fragmentLists)
        adapter.setPageTitles(titles)

        vp_pageViewer.adapter = adapter
        tl_tabLayout.setupWithViewPager(vp_pageViewer)

        tl_tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home->{
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
