package com.example.noodlenetworkplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_LIST_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.ID_PUBLICACIONES
import com.example.noodlenetworkplus.ForoDeComunidadActivity.Companion.gson
import com.example.noodlenetworkplus.RegisterActivity.Companion.USERNAME
import com.example.noodlenetworkplus.RegisterTimeActivity.Companion.APP_PREFERENCES
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ActivityAgregarPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.reflect.TypeToken
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AgregarPostActivity : BaseActivity() {
    private lateinit var binding: ActivityAgregarPostBinding
    private lateinit var auth: FirebaseAuth
    private var categoria: Int = R.drawable.user            //Imagen default de la categoría del post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val usernameString = sharedPreferences.getString(USERNAME, "Usuario").toString()

        auth = FirebaseAuth.getInstance()
        //Establece la categoría del nuevo post
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
                    categoria = R.drawable.user         //Si no se selecciona ninguna opción verificada, cargamos imagen default
                }
            }
        }

        binding.postButtonAdd.setOnClickListener{
            val contenido: String = binding.postEditText.text.toString()                //Guardamos el contenido del editText
            if (contenido.isNotEmpty()) {                                               //Si el contenido no está vacío
                agregarPublicacion(usernameString, contenido)       //Se agrega la publicación
                binding.postEditText.text.clear()                                       //Y se limpia el contenido de editText
                val intent = Intent(this, ForoDeComunidadActivity::class.java)
                startActivity(intent)
            } else {
                //Si el contenido está vacío se envía una advertencia al usuario
                binding.postEditText.hint = getString(R.string.newPostHintOnEmpty)
            }
        }
        binding.postButtonBack.setOnClickListener{onBackPressed()}                      //Salida a la pantalla anterior
    }

    //Función para guardar la publicación y añadirla a la lista anterior
    private fun agregarPublicacion(usuario: String, contenido: String) {
        val actual: LocalDateTime = LocalDateTime.now()             //Guardamos la fecha y hora actual
        val post = mutableListOf(                                   //Creación del post en una nueva lista
            Publicacion (
            autor = usuario,
            fechaDePublicacion = actual.format(DateTimeFormatter.ofPattern("dd/MM/yy")).toString(),
            horaDePublicacion = actual.format(DateTimeFormatter.ofPattern("HH:mm")).toString(),
            contenido = contenido,
            imagen = categoria
            )
        )
        post.addAll(cargarPublicaciones())                          //A la lista se le agregan todas las publicaciones anteriores
        guardarPublicaciones(post)                                  //Se guarda la nueva lista
    }

    //Función que guarda la lista de publicaciones en SharedPreferences
    private fun guardarPublicaciones(publicaciones: MutableList<Publicacion>) {
        val editor = this.getSharedPreferences(ID_LIST_PUBLICACIONES, Context.MODE_PRIVATE).edit()
        editor.putString(ID_PUBLICACIONES, gson.toJson(publicaciones))
        editor.apply()
    }

    //Función que carga las publicaciones anteriores desde SharedPreferences
    private fun cargarPublicaciones(): MutableList<Publicacion> {
        val json = this.getSharedPreferences(ID_LIST_PUBLICACIONES, Context.MODE_PRIVATE).getString(ID_PUBLICACIONES, null)
        val tipo = object : TypeToken<List<Publicacion>>() {}.type
        return if (json != null) gson.fromJson(json, tipo) else mutableListOf<Publicacion>()
    }
}