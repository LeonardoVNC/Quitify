package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class IntroActivity : BaseActivity() {

    private lateinit var presentacionList: List<Presentacion>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        presentacionList= listOf(
            Presentacion(
                fondo= R.drawable.gradient_background,
                image= R.drawable.welcome_one,
                titulo = getString(R.string.welcomeTitle1),
                descripcion = getString(R.string.welcomeDesc1)
            ),Presentacion(
                fondo= R.drawable.gradient_background,
                image= R.drawable.welcome_two,
                titulo = getString(R.string.welcomeTitle2),
                descripcion = getString(R.string.welcomeDesc2)
            ),Presentacion(
                fondo= R.drawable.gradient_background,
                image= R.drawable.welcome_three,
                titulo = getString(R.string.welcomeTitle3),
                descripcion = getString(R.string.welcomeDesc3)
            )
        )
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPagerAdapter(presentacionList, viewPager)
        viewPager.adapter = adapter

    }
}