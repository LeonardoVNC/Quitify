package com.example.noodlenetworkplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_LIST_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.gson
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityAgregarPostBinding
import com.google.gson.reflect.TypeToken
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AgregarPostActivity : BaseActivity() {
    private lateinit var binding: ActivityAgregarPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.postButtonAdd.setOnClickListener{
            //TODO Aun es necesario agregar el nombre de usuario y establecer funcionalidad de la imágen
            agregarPublicacion("test", binding.postEditText.text.toString(), R.drawable.add)

            binding.postEditText.text.clear()
            val intent = Intent(this, ForoDeComunidadActivity::class.java)
            startActivity(intent)
        }
        binding.postButtonBack.setOnClickListener{onBackPressed()}
    }

    fun agregarPublicacion(usuario: String, contenido: String, idImagen: Int) {
        val post = mutableListOf(
            Publicacion (
            autor = usuario,
            fechaDePublicacion = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")).toString(),
            contenido = contenido,
            imagen = idImagen
            )
        )
        post.addAll(cargarPublicaciones())
        guardarPublicaciones(post)
    }

    fun guardarPublicaciones(publicaciones: MutableList<Publicacion>) {
        val editor = this.getSharedPreferences(ID_LIST_PUBLICACIONES, Context.MODE_PRIVATE).edit()
        editor.putString(ID_PUBLICACIONES, gson.toJson(publicaciones))
        editor.apply()
    }

    fun cargarPublicaciones(): MutableList<Publicacion> {
        val json = this.getSharedPreferences(ID_LIST_PUBLICACIONES, Context.MODE_PRIVATE).getString(ID_PUBLICACIONES, null)
        val tipo = object : TypeToken<List<Publicacion>>() {}.type
        return if (json != null) gson.fromJson(json, tipo) else mutableListOf<Publicacion>()
    }
}