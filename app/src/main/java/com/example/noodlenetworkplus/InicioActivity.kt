package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.noodlenetworkplus.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    private val handler = Handler(Looper.getMainLooper())
    //TODO verificar si el usuario ya inició sesión
    private var login: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DarkTur)
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        handler.postDelayed({iniciarApp()}, 2500)
    }

    private fun iniciarApp() {
        if (login) {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        } else {
            //TODO Aqui en vez de Configuracion hay que redirigirlo al inicion de sesión
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}