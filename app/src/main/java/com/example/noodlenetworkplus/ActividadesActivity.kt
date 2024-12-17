package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapters.ActividadesAdapter
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
                     Actividad(titulo = "Dominadas", descripcion = "Intenta realizar 10 dominadas seguidas sin fallar. Mantén la concentración y demuestra tu fuerza. ¡Tú puedes lograrlo!"),
                     Actividad(titulo = "Canastas", descripcion = "Desafíate a encestar 5 tiros de 3 puntos seguidos. Controla tu puntería y demuestra tu habilidad. ¿Listo para intentarlo?"),
                     Actividad(titulo = "Digita", descripcion = "Realiza 20 digitaciones manteniendo el balón en el aire sin que caiga al suelo. ¡Mantén el control y no te rindas!")
                 )
            }
            "Dibujo" -> {
                list = mutableListOf(
                    Actividad(titulo = "Boceto rápido", descripcion = "Crea un boceto en solo 10 minutos. No importa la perfección, ¡deja que fluya tu creatividad!"),
                    Actividad(titulo = "Paisaje imaginario", descripcion = "Dibuja un paisaje de tu imaginación, con montañas, ríos o lo que te inspire. ¡Dale vida a tus ideas!"),
                    Actividad(titulo = "Personaje único", descripcion = "Diseña un personaje original con detalles únicos. ¡Deja que tu estilo brille en cada trazo!")
                )
            }
            "Cocina" -> {
                list = mutableListOf(
                    Actividad(titulo = "Prepara un budín", descripcion = "Sigue una receta sencilla y prepara un budín suave y delicioso. Combina harina, huevos, leche y tus ingredientes favoritos, ¡y llévalo al horno!"),
                    Actividad(titulo = "Haz una pizza casera", descripcion = "Crea una pizza desde cero. Amasa la base, agrega salsa de tomate, queso y tus toppings favoritos, ¡y hornéala hasta que quede perfecta!"),
                    Actividad(titulo = "Batido refrescante", descripcion = "Prepara un batido con frutas frescas, leche o yogurt, y un toque de miel. ¡Ideal para un día caluroso!")
                )
            }
            "Musica" -> {
                list = mutableListOf(
                    Actividad(titulo = "Escribe una canción", descripcion = "Usa un cuaderno y escribe la letra de una canción. Agrega un ritmo básico golpeando la mesa o usando una aplicación musical."),
                    Actividad(titulo = "Crea un playlist único", descripcion = "Selecciona tus canciones favoritas y crea un playlist que refleje tu estado de ánimo. ¡Perfecto para inspirarte o relajarte!"),
                    Actividad(titulo = "Dibuja tu música", descripcion = "Escucha una canción y dibuja lo que sientes o lo que te inspira. Transforma los sonidos en imágenes."),
                    )
            }
            else -> {
                println("Noodle")
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