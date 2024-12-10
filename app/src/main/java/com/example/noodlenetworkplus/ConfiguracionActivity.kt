package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityConfiguracionBinding

class ConfiguracionActivity : BaseActivity() {
    private lateinit var binding: ActivityConfiguracionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.configButtonBack.setOnClickListener{onBackPressed()}
        binding.configButtonAccount.setOnClickListener{
            //TODO Implementar esta pantalla
        }
        binding.configButtonTheme.setOnClickListener{
            val intent = Intent(this, SelectThemeActivity::class.java)
            startActivity(intent)
        }
        binding.configButtonCloseAccount.setOnClickListener{
            //TODO Implementar esta pantalla
        }
    }
}