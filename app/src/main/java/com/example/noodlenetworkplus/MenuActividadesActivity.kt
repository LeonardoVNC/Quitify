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
    private lateinit var binding : ActivityMenuActividadesBinding //Inicialización tardia de binding para la interacción con las vistas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.menuactButtonMenu.setOnClickListener { // Reconoce si el boton "ButtonMenu" fue presionado
            val intent = Intent(this, ConfiguracionActivity::class.java)// lleva a la pantalla "Configuracion"
            startActivity(intent)//comienza el intent
        }
        binding.menuactButtonTime.setOnClickListener {// Reconoce si el boton "ButtonTime" fue presionado
            val intent = Intent(this, PrincipalActivity::class.java)// lleva a la pantalla "Principal"
            startActivity(intent)//comienza el intent
        }
        binding.menuactButtonCommunity.setOnClickListener {// Reconoce si el boton "ButtonCommunity" fue presionado
            val intent = Intent(this, ForoDeComunidadActivity::class.java)// lleva a la pantalla "Foro de Comunidad"
            startActivity(intent)//comienza el intent
        }

        // Botones del menu de Recomendaciones/Actividades
        binding.menuactDeporte.setOnClickListener { // Reconoce si el boton "Deporte" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Deporte") //Coloca como categoría "Deporte"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactDibujo.setOnClickListener {// Reconoce si el boton "Dibujo" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Dibujo")//Coloca como categoría "Dibujo"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactCocina.setOnClickListener {// Reconoce si el boton "Cocina" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Cocina")//Coloca como categoría "Cocina"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactMusica.setOnClickListener {// Reconoce si el boton "Musica" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Musica")//Coloca como categoría "Musica"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactPoesia.setOnClickListener {// Reconoce si el boton "Poesia" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Poesia")//Coloca como categoría "Poesia"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactAprendizaje.setOnClickListener {// Reconoce si el boton "Aprendizaje" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Aprendizaje")//Coloca como categoría "Aprendizaje"
            startActivity(intent)//inicialización el intent
        }
        binding.menuactVideojuegos.setOnClickListener {// Reconoce si el boton "Videojuegos" fue presionado
            val intent = Intent(this, ActividadesActivity::class.java)// lleva a la pantalla de recomendaciones de la categoria
            intent.putExtra(ID_CATEGORIA,"Videojuegos")//Coloca como categoría "Videojuegos"
            startActivity(intent)//inicialización el intent
        }
    }
}