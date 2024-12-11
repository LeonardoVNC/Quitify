package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapters.ForoDeComunidadAdapter.ForoDeComunidadAdapter
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityForoDeComunidadBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ForoDeComunidadActivity : BaseActivity() {
    private lateinit var binding: ActivityForoDeComunidadBinding
    private val recyclerPostAdapter by lazy {ForoDeComunidadAdapter()}
    private var listaPublicaciones = mutableListOf<Publicacion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForoDeComunidadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //TEST
        agregarPublicacion("User1", "publicando algo muy seriooo", R.drawable.add)
        agregarPublicacion("User2", "publicando algo menos seriooo", R.drawable.menu3)
        agregarPublicacion("User3", "publicando algo nada seriooo", R.drawable.community)
        agregarPublicacion("User4", "publicando algo demasiado seriooo", R.drawable.arrow_back)
        //TEST
        setUpRecyclerView()

        binding.communityButtonAdd.setOnClickListener {
            val intent = Intent(this, AgregarPostActivity::class.java)
            startActivity(intent)
        }

        binding.communityButtonTime.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
    }

    fun setUpRecyclerView() {
        recyclerPostAdapter.addDataToList(listaPublicaciones)
        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerPostAdapter
        }
    }

    fun agregarPublicacion(usuario: String, contenido: String, idImagen: Int) {
        val post = mutableListOf(Publicacion (
            autor = usuario,
            fechaDePublicacion = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")).toString(),
            contenido = contenido, imagen = idImagen)
        )
        post.addAll(listaPublicaciones)
        listaPublicaciones = post
        setUpRecyclerView()
    }
}