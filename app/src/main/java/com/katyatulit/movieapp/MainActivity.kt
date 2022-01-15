package com.katyatulit.movieapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.katyatulit.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation() // show toast messages when menu and navigation items are pressed
    }

    private fun initNavigation() {

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener () {

            when (it.itemId) {
                R.id.favorites, R.id.watch_later, R.id.selections -> {
                    Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        val animationPoster2 = AnimationUtils.loadAnimation(this, R.anim.poster_animation)
        binding.poster2.setOnClickListener {
            it.startAnimation(animationPoster2)
        }

        binding.poster3.setOnClickListener {
            val animatorPoster3 = ObjectAnimator.ofFloat(it, View.ROTATION, 0F, 360F)
            animatorPoster3.duration = 500
            animatorPoster3.start()
        }

        binding.poster4.setOnClickListener {

            val animation1 = ObjectAnimator.ofFloat(it, View.ALPHA, 0F, 1F)
            animation1.interpolator = BounceInterpolator()
            animation1.duration = 1000

            val animation2 = ObjectAnimator.ofFloat(it, View.ROTATION, 0F, 360F)
            animation2.duration = 500

            val animatorSet = AnimatorSet()
            animatorSet.play(animation1)
            animatorSet.play(animation2).after(1000)
            animatorSet.start()
        }

    }
}
