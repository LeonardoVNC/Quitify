package com.example.noodlenetworkplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapters.ForoDeComunidadAdapter.ForoDeComunidadAdapter
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityForoDeComunidadBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ForoDeComunidadActivity : BaseActivity() {
    private lateinit var binding: ActivityForoDeComunidadBinding
    private val recyclerPostAdapter by lazy {ForoDeComunidadAdapter()}

    companion object{
        val gson = Gson()
        val ID_LIST_PUBLICACIONES = "LISTA_PUBLICACIONES"
        val ID_PUBLICACIONES = "PUBLICACIONES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForoDeComunidadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpRecyclerView()

        binding.communityButtonMenu.setOnClickListener {
            val intent = Intent(this, ConfiguracionActivity::class.java)
            startActivity(intent)
        }
        binding.communityButtonAdd.setOnClickListener {
            val intent = Intent(this, AgregarPostActivity::class.java)
            startActivity(intent)
        }
        binding.communityButtonTime.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
        binding.communityButtonTask.setOnClickListener {
            val intent = Intent(this, ActividadesActivity::class.java)
            startActivity(intent)
        }
    }

    fun setUpRecyclerView() {
        recyclerPostAdapter.addDataToList(cargarPublicaciones())
        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerPostAdapter
        }
    }

    fun cargarPublicaciones(): MutableList<Publicacion> {
        val json = this.getSharedPreferences(ID_LIST_PUBLICACIONES, Context.MODE_PRIVATE).getString(ID_PUBLICACIONES, null)
        val tipo = object : TypeToken<List<Publicacion>>() {}.type
        return if (json != null) gson.fromJson(json, tipo) else mutableListOf<Publicacion>()
    }
}