package com.example.noodlenetworkplus

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.RegisterAdictionActivity.Companion.USER_ADDICTION
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.BEGIN_DATE
import com.example.noodlenetworkplus.databinding.ActivityDetallesCuentaBinding
import com.google.firebase.auth.FirebaseAuth
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetallesCuentaActivity : BaseActivity() {
    private lateinit var binding: ActivityDetallesCuentaBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesCuentaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()
        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val adictionString = sharedPreferences.getString(USER_ADDICTION, "una adicción").toString()
        val beginDateString = LocalDateTime.parse(sharedPreferences.getString(BEGIN_DATE, LocalDateTime.now().toString()))

        mostrarDatosPersonales(adictionString, beginDateString)

        binding.accountButtonBack.setOnClickListener{onBackPressed()}
    }

    fun mostrarDatosPersonales(adiccion: String, inicio: LocalDateTime) {
        binding.accountTextUsername.text = auth.currentUser?.email.toString()
        binding.accountTextAdic.text = "Actualmente me estoy limpiando de $adiccion"
        binding.accountTextDate.text = "Empecé con este reto el ${inicio.format(DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm")).toString()}"
    }
}