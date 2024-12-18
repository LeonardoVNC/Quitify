package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.noodlenetworkplus.adapters.ViewPagerAdapter
import com.example.noodlenetworkplus.dataClasses.Presentacion

class IntroActivity : AppCompatActivity() {

    // Lista que contendrá las presentaciones de la introducción
    private lateinit var presentacionList: List<Presentacion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Inicializamos la lista de presentaciones con 3 elementos
        presentacionList = listOf(
            // Primera presentación con fondo, imagen, título y descripción
            Presentacion(
                fondo = R.drawable.gradient_background,
                image = R.drawable.welcome_one,
                titulo = getString(R.string.welcomeTitle1),
                descripcion = getString(R.string.welcomeDesc1)
            ),
            // Segunda presentación
            Presentacion(
                fondo = R.drawable.gradient_background,
                image = R.drawable.welcome_two,
                titulo = getString(R.string.welcomeTitle2),
                descripcion = getString(R.string.welcomeDesc2)
            ),
            // Tercera presentación
            Presentacion(
                fondo = R.drawable.gradient_background,
                image = R.drawable.welcome_three,
                titulo = getString(R.string.welcomeTitle3),
                descripcion = getString(R.string.welcomeDesc3)
            )
        )

        // Obtenemos la referencia del ViewPager2 del layout
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Creamos y asignamos el adaptador para el ViewPager2, que mostrará las presentaciones
        val adapter = ViewPagerAdapter(presentacionList, viewPager)
        viewPager.adapter = adapter
    }
}