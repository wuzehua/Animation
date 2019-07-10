package com.example.animationdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sb_lottieButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(v: View?) {
                val intent = Intent()
                intent.setClass(this@MainActivity, LottieDemoActivity::class.java)
                startActivity(intent)
            }

        })

        sb_paButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(v: View?) {
                val intent = Intent()
                intent.setClass(this@MainActivity, PropertyAnimationActivity::class.java)
                startActivity(intent)
            }
        })

        sb_fragmentButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(p0: View?) {
                val intent = Intent()
                intent.setClass(this@MainActivity, FragmentDemo::class.java)
                startActivity(intent)
            }

        })
    }
}
