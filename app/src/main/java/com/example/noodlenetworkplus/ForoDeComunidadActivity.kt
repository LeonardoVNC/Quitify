package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapters.ForoDeComunidadAdapter.ForoDeComunidadAdapter
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityForoDeComunidadBinding

class ForoDeComunidadActivity : BaseActivity() {
    private lateinit var binding: ActivityForoDeComunidadBinding

    private val recyclerPostAdapter by lazy {ForoDeComunidadAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForoDeComunidadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpRecyclerView()

        binding.communityButtonTime.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
    }

    fun setUpRecyclerView() {
        val listaDatos = mutableListOf(
            Publicacion(autor = "JoseJuan14", fechaDePublicacion = "14-05-24", contenido = "La verdad no se bien que estoy haciendo nomas ando escribiendo un re muro de texto muajajaja tengo sueño loco"),
            Publicacion(autor = "RompeNabos89", fechaDePublicacion = "15-06-24", contenido = "You are not the same anymore, dont wanna play that game anymore, you'd make a better window than a door, all the strangers they implore, they get so easy to ignore, just like the girl next door"),
            Publicacion(autor = "Mr420", fechaDePublicacion = "17-04-24", contenido = "I didnt know, i didnt care, i dont even understand, did something wrong?, i wasnt sure, stay on top of this horse, i was afraid, i fucked up, i couldnt change, its too late."),
            Publicacion(autor = "Pelati", fechaDePublicacion = "9/12/24", contenido = "Avanzo y escribo, decido el camino, las ganas que quedan se marchan con vos, se apaga el deseo, ya no me entreveo, y hablar es lo que se me va mejor, con los ojos no te veo, sé que se me viene el mareo, y es entonces cuando quiero salir a caminar, con los ojos no te veo, sé que se me viene el mareo, y es entonces cuando quiero salir a caminar, el aire me ciega, hay vidrio en la arena, ya no me da pena,dejarte un adios, asi son las cosas, amargas borrosas, son fotos veladas de un tiempo mejor"),
            Publicacion(autor = "YoshuaGod", fechaDePublicacion = "23-12-24", contenido = "...")
        )

        recyclerPostAdapter.addDataToList(listaDatos)

        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerPostAdapter
        }
    }
}