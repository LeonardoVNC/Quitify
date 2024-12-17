package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.databinding.ActivityInicioBinding
import com.google.firebase.auth.FirebaseAuth

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    private lateinit var auth: FirebaseAuth
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DarkTur)                             //El tema se mantiene sin importar las preferencias del usuario
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        handler.postDelayed({iniciarApp()}, 2000)           //Después de 2 segundos se inicia la App
    }

    private fun iniciarApp() {
        if (auth.currentUser != null) {         //Si ya hay una sesión iniciada
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)               //Se carga PrincipalActivity
        } else {                                //Si no hay sesión iniciada
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)               //Se carga LoginActivity
        }
        finish()                                //La activity se borra del backstack
    }
}