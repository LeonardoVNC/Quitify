package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noodlenetworkplus.ActividadesActivity.Companion.ID_CATEGORIA
import com.example.noodlenetworkplus.databinding.ActivityActividadesBinding
import com.example.noodlenetworkplus.databinding.ActivityMenuActividadesBinding

class MenuActividadesActivity : BaseActivity() {
    private lateinit var binding : ActivityMenuActividadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.menuactButtonMenu.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }
        binding.menuactButtonTime.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
        binding.menuactButtonCommunity.setOnClickListener {
            val intent = Intent(this, ForoDeComunidadActivity::class.java)
            startActivity(intent)
        }

        // Para cargar todas las categorias de Actividades
        binding.menuactDeporte.setOnClickListener {
            val intent = Intent(this, ActividadesActivity::class.java)
            intent.putExtra(ID_CATEGORIA,"Deporte")
            startActivity(intent)
        }
        binding.menuactArte.setOnClickListener {
            val intent = Intent(this, ActividadesActivity::class.java)
            intent.putExtra(ID_CATEGORIA,"Arte")
            startActivity(intent)
        }
    }
}