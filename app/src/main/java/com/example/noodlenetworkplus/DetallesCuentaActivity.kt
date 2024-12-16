package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityDetallesCuentaBinding

class DetallesCuentaActivity : BaseActivity() {
    private lateinit var binding: ActivityDetallesCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesCuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mostrarDatosPersonales()

        binding.accountButtonBack.setOnClickListener{onBackPressed()}
    }

    fun mostrarDatosPersonales() {
        //TODO Acceder al username desde la información almacenada en la aplicación
        //binding.accountTextUsername.text = ...

        //TODO Acceder a la adicción desde la información almacenada en la aplicación
        binding.accountTextAdic.text = "Actualmente me estoy limpiando de ${getString(R.string.accountAdic)}"

        //TODO Acceder a la fecha de inicio desde la información almacenada en la aplicación
        binding.accountTextDate.text = "Empecé con este reto el ${getString(R.string.accountDate)}"
    }
}