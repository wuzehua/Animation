package com.example.animationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import android.view.View
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_fragment_demo.*

class FragmentDemo : AppCompatActivity() {

    val titles = arrayOf("1","2","3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)

        val actionBar = supportActionBar

        if(actionBar != null)
        {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        for(i in 0 until 3)
        {
            tl_tabLayout.addTab(tl_tabLayout.newTab().setText(titles[i]))
        }

        tl_tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener
        {
            override fun onTabReselected(p0: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null)
                    return

                val position = tab.position

                val manager = supportFragmentManager
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.fl_frameLayout, TextFragment.newInstance("Fragment ${position + 1}"))
                transaction.commit()

            }

        })

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fl_frameLayout, TextFragment.newInstance("Fragment 1"))
        transaction.commit()
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
