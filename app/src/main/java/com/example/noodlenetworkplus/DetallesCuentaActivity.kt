package com.example.noodlenetworkplus

import android.os.Bundle
import com.example.noodlenetworkplus.databinding.ActivityDetallesCuentaBinding
import android.content.Context


class DetallesCuentaActivity : BaseActivity() {
    private lateinit var binding: ActivityDetallesCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesCuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mostrarDatosPersonales()
        binding.accountButtonBack.setOnClickListener { onBackPressed() }
    }

    fun mostrarDatosPersonales() {
        val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Usuario")

        binding.accountTextUsername.text = "$username"
        binding.accountTextAdic.text = "Actualmente me estoy limpiando de ${getString(R.string.accountAdic)}"
        binding.accountTextDate.text = "Empecé con este reto el ${getString(R.string.accountDate)}"
    }
}
