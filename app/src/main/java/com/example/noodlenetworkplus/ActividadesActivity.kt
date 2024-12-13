package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapter.ActividadesAdapter.ActividadesAdapter
import com.example.noodlenetworkplus.dataClasses.Actividad
import com.example.noodlenetworkplus.databinding.ActivityActividadesBinding

class ActividadesActivity : BaseActivity() {
    private lateinit var binding: ActivityActividadesBinding
    private val recyclerActivityAdapter by lazy { ActividadesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpRecyclerView()
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
    fun setUpRecyclerView(){
        val listaDatos = mutableListOf(
            Actividad(titulo="Dominadas",descripcion="Has 50 dominadas con el balon"),
            Actividad(titulo="Canastas",descripcion="Has 50 dominadas con el balon"),
            Actividad(titulo="Tenis de mesa",descripcion="Has 50 dominadas con el balon")
        )
        recyclerActivityAdapter.addDataToList(listaDatos)
        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerActivityAdapter
        }
    }
}