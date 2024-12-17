package com.example.noodlenetworkplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_LIST_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.gson
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityAgregarPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.reflect.TypeToken
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AgregarPostActivity : BaseActivity() {
    private lateinit var binding: ActivityAgregarPostBinding
    private lateinit var auth: FirebaseAuth
    private var categoria: Int = R.drawable.user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        binding.postRadioGroup.setOnCheckedChangeListener { group, checkedID ->
            when(checkedID) {
                R.id.post_radio_button_support -> {
                    categoria = R.drawable.hugging
                }
                R.id.post_radio_button_celebration -> {
                    categoria = R.drawable.celebration
                }
                R.id.post_radio_button_sad -> {
                    categoria = R.drawable.mask_sad
                }
                else -> {
                    categoria = R.drawable.user
                }
            }
        }
        binding.postButtonAdd.setOnClickListener{
            val contenido: String = binding.postEditText.text.toString()
            if (contenido.isNotEmpty()) {
                agregarPublicacion(auth.currentUser?.email.toString(), contenido)
                binding.postEditText.text.clear()
                val intent = Intent(this, ForoDeComunidadActivity::class.java)
                startActivity(intent)
            } else {
                binding.postEditText.hint = getString(R.string.newPostHintOnEmpty)
            }
        }
        binding.postButtonBack.setOnClickListener{onBackPressed()}
    }

    fun agregarPublicacion(usuario: String, contenido: String) {
        val actual: LocalDateTime = LocalDateTime.now()
        val post = mutableListOf(
            Publicacion (
            autor = usuario,
            fechaDePublicacion = actual.format(DateTimeFormatter.ofPattern("dd/MM/yy")).toString(),
            horaDePublicacion = actual.format(DateTimeFormatter.ofPattern("HH:mm")).toString(),
            contenido = contenido,
            imagen = categoria
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