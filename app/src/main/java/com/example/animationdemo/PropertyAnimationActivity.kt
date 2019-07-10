package com.example.animationdemo

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_property_animation.*

class PropertyAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animation)

        val actionBar = supportActionBar

        val bitmap = BitmapFactory.decodeResource(resources, R.raw.test)
        paletteView.setBitmap(bitmap)


        if(actionBar != null)
        {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        sb_alphaButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(v: View?) {
                val animator = AnimatorInflater.loadAnimator(this@PropertyAnimationActivity, R.animator.alpha)
                animator.setTarget(findViewById(R.id.paletteView))
                animator.start()
            }

        })

        sb_scaleButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(p0: View?) {
                val animator = AnimatorInflater.loadAnimator(this@PropertyAnimationActivity,R.animator.scale)
                animator.setTarget(findViewById(R.id.paletteView))
                animator.start()
            }

        })

        sb_mixButton.setOnClickListener(object: View.OnClickListener
        {
            override fun onClick(p0: View?) {
                val animatorSet = AnimatorSet()
                val alpha = AnimatorInflater.loadAnimator(this@PropertyAnimationActivity, R.animator.alpha)
                val scale = AnimatorInflater.loadAnimator(this@PropertyAnimationActivity,R.animator.scale)
                animatorSet.playTogether(alpha, scale)
                animatorSet.setTarget(findViewById(R.id.paletteView))
                animatorSet.start()
            }

        })

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
