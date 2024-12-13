package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.databinding.ActivityActividadesBinding

class ActividadesActivity : BaseActivity() {
    private lateinit var binding: ActivityActividadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // TODO setUpRecyclerView
        binding.recomendationButtonMenu.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }
        binding.recomendationButtonTime.setOnClickListener(){
            val intent = Intent(this,PrincipalActivity::class.java)
            startActivity(intent)
        }
        binding.recomendationButtonCommunity.setOnClickListener(){
            val intent = Intent(this,ForoDeComunidadActivity::class.java)
            startActivity(intent)
        }
    }
}