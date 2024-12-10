package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityAgregarPostBinding

class AgregarPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.postButtonAdd.setOnClickListener{
            //TODO se debe guardar el editText.text en los JSON
            println("Se deberia guardar el siguiente texto: ${binding.postEditText.text}")

            binding.postEditText.text.clear()
            val intent = Intent(this, ForoDeComunidadActivity::class.java)
            startActivity(intent)
        }
        binding.postButtonBack.setOnClickListener{onBackPressed()}
    }
}