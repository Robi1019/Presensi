package com.example.presensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val SPLASH_SCREEN = 5000

    private lateinit var topanimation: Animation
    private lateinit var bottomanimation: Animation

    private lateinit var imageView: ImageView
    private lateinit var title_text: TextView
    private lateinit var deskrip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_anim)

        imageView = findViewById(R.id.logo)
        title_text = findViewById(R.id.title_text)
        deskrip = findViewById(R.id.deskrip)

        imageView.animation = topanimation
        title_text.animation = bottomanimation
        deskrip.animation = bottomanimation

        Handler().postDelayed({
            val  intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())
    }
}