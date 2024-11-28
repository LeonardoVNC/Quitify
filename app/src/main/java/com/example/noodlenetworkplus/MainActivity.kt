package com.example.noodlenetworkplus

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private var tema: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (tema == 0) {
            setTheme(R.style.Theme_DarkTur)
            tema++
        } else if (tema == 1) {
            setTheme(R.style.Theme_Dark)
            tema++
        } else if (tema == 2) {
            setTheme(R.style.Theme_DarkPurple)
            tema++
        } else if (tema == 3) {
            setTheme(R.style.Theme_Light)
            tema = 0
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonCambioTema: Button = findViewById(R.id.test_button)
        botonCambioTema.setOnClickListener{
            recreate()
        }
    }
}