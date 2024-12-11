package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class IntroActivity : AppCompatActivity() {

    private lateinit var presentacionList: List<Presentacion>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        presentacionList= listOf(
            Presentacion(
                fondo= R.color.white,
                image= R.drawable.icono_persona,
                titulo = "HOLAA",
                descripcion = "CHAAU"
            ),Presentacion(
                fondo= R.color.white,
                image= R.drawable.icono_persona,
                titulo = "HOLAA",
                descripcion = "CHAAU"
            ),Presentacion(
                fondo= R.color.black,
                image= R.drawable.menu3,
                titulo = "HOLAA",
                descripcion = "CHAAU"
            )
        )
        val adapter = ViewPagerAdapter(presentacionList)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
    }
}