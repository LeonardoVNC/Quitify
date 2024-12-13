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
    companion object {
        val ID_CATEGORIA = "CATEGORIA"
    }

    private lateinit var binding: ActivityActividadesBinding
    private val recyclerActivityAdapter by lazy { ActividadesAdapter() }
    private val listaDeDatos = mutableListOf<Actividad>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tipo = intent.getStringExtra(ID_CATEGORIA) ?: "error"
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        verificarCategoria(tipo)
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
    fun verificarCategoria(categoria: String){
        var list = mutableListOf<Actividad>()
        when(categoria){
            "Deporte" -> {
                 list = mutableListOf(
                     Actividad(titulo = "Dominadas", descripcion = "Haz dominadas"),
                     Actividad(titulo = "Donadas", descripcion = "Haz dominadas"),
                     Actividad(titulo = "Dodas", descripcion = "Haz dominadas")
                 )
            }
            "Arte" -> {
                list = mutableListOf(
                    Actividad(titulo = "A", descripcion = "Haz dominadas"),
                    Actividad(titulo = "B", descripcion = "Haz dominadas"),
                    Actividad(titulo = "C", descripcion = "Haz dominadas")
                )
            }
            else -> {
                println("esto no funciona!!!!")
            }
        }
        listaDeDatos.addAll(list)
    }
    fun setUpRecyclerView(){
        recyclerActivityAdapter.addDataToList(listaDeDatos)
        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerActivityAdapter
        }
    }
}