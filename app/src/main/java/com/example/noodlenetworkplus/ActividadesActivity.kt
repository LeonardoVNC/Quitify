package com.example.noodlenetworkplus

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noodlenetworkplus.adapters.ActividadesAdapter
import com.example.noodlenetworkplus.dataClasses.Actividad
import com.example.noodlenetworkplus.databinding.ActivityActividadesBinding

class ActividadesActivity : BaseActivity() {
    //Objeto estatido para para definir constantes metodos accesibles sin necesidad de instanciar la clase
    companion object {
        val ID_CATEGORIA = "CATEGORIA"
    }

    private lateinit var binding: ActivityActividadesBinding//Inicialización tardia de binding para la interacción con las vistas
    private val recyclerActivityAdapter by lazy { ActividadesAdapter() }
    private val listaDeDatos = mutableListOf<Actividad>()//lista mutable que guarda la actividad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tipo = intent.getStringExtra(ID_CATEGORIA) ?: "error"//Recuperar el dato extra "Categoria" con Intent, si este es vacio entonces devolvera error
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        verificarCategoria(tipo)//Verificacion de los dato segun la categoria
        setUpRecyclerView()//configuracion del RecyclerView segun los datos y el adapter

        binding.recomendationButtonMenu.setOnClickListener { // Reconoce si el boton "ButtonMenu" fue presionado
            val intent = Intent(this, ConfiguracionActivity::class.java) // lleva a la pantalla "Configuracion"
            startActivity(intent) //comienza el intent
        }
        binding.recomendationButtonTime.setOnClickListener(){ // Reconoce si el boton "ButtonTime" fue presionado
            val intent = Intent(this,PrincipalActivity::class.java) // lleva a la pantalla "Principal"
            startActivity(intent)//comienza el intent
        }
        binding.recomendationButtonCommunity.setOnClickListener(){ // Reconoce si el boton "ButtonCommunity" fue presionado
            val intent = Intent(this,ForoDeComunidadActivity::class.java) // lleva a la pantalla "Foro de Comunidad"
            startActivity(intent)//comienza el intent
        }
    }
    fun verificarCategoria(categoria: String){//Funcion que recibe un String
        var list = mutableListOf<Actividad>()//Creaccion de una lista mutable pra alamacenar objetos de tipo actividad
        when(categoria){//Reconoce que tipo de Actividad es segun la categoria
            "Deporte" -> {// Si el boton presionado tiene el nombre de "Deporte" entonces:
                 list = mutableListOf(//Se llena la lista con los siguiente datos
                     //Actividades
                     Actividad(titulo = "Dominadas", descripcion = "Intenta realizar 10 dominadas seguidas sin fallar. Mantén la concentración y demuestra tu fuerza. ¡Tú puedes lograrlo!","",""),
                     Actividad(titulo = "Canastas", descripcion = "Desafíate a encestar 5 tiros de 3 puntos seguidos. Controla tu puntería y demuestra tu habilidad. ¿Listo para intentarlo?","",""),
                     Actividad(titulo = "Digita", descripcion = "Realiza 20 digitaciones manteniendo el balón en el aire sin que caiga al suelo. ¡Mantén el control y no te rindas!","",""),
                     Actividad(titulo = "Carrera de velocidad", descripcion = "Corre 100 metros lo más rápido que puedas. Mide tu tiempo y desafíate a mejorarlo.","",""),
                     Actividad(titulo = "Saltos de cuerda", descripcion = "Realiza 50 saltos de cuerda seguidos sin detenerte. ¡Coordina tu ritmo y diviértete!","",""),
                     Actividad(titulo = "Tiros al arco", descripcion = "Intenta marcar 5 goles desde fuera del área con el balón. ¡Trabaja tu precisión y potencia!","",""),
                     Actividad(titulo = "Tiros con efecto", descripcion = "Practica disparos con efecto hacia una portería o blanco específico. ¡Ponle curva al balón y desafía tu precisión!","","")
                 )
            }
            "Dibujo" -> {//  Si el boton presionado tiene el nombre de "Dibujo" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Boceto rápido", descripcion = "Crea un boceto en solo 10 minutos. No importa la perfección, deja que fluya tu creatividad","",""),
                    Actividad(titulo = "Paisaje imaginario", descripcion = "Dibuja un paisaje de tu imaginación, con montañas, ríos o lo que te inspire. ¡Dale vida a tus ideas!","",""),
                    Actividad(titulo = "Personaje único", descripcion = "Diseña un personaje original con detalles únicos. ¡Deja que tu estilo brille en cada trazo!", "",""),
                    Actividad(titulo = "Dibujo a ciegas", descripcion = "Cierra los ojos y dibuja un objeto simple, como una casa o un árbol. Luego observa tu resultado y diviértete.", "",""),
                    Actividad(titulo = "Retrato express", descripcion = "Dibuja un autorretrato o el de alguien más en solo 5 minutos. ¡No te detengas en los detalles, solo las formas básicas!","",""),
                    Actividad(titulo = "Cómic corto", descripcion = "Crea una tira cómica de 3 viñetas contando una historia simple y divertida. ¡Dale vida a tus personajes!","",""),
                    Actividad(titulo = "Dibujo con una línea", descripcion = "Dibuja cualquier objeto sin levantar el lápiz del papel. ¡Desafía tu pulso y creatividad!","",""),
                    Actividad(titulo = "Animal híbrido", descripcion = "Diseña un animal inventado combinando dos especies. Deja volar tu imaginación","",""),
                    Actividad(titulo = "Escena de tu día", descripcion = "Dibuja una escena de algo que hiciste hoy, como tu habitación, una comida o una caminata.","","")
                )
            }
            "Cocina" -> {//  Si el boton presionado tiene el nombre de "Cocina" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Prepara un budín", descripcion = "Sigue una receta sencilla y prepara un budín suave y delicioso. Una pequeña ayuda para prepararlo: ", "Budin delicioso","https://www.youtube.com/watch?v=iTsmADW4f2M"),
                    Actividad(titulo = "Haz una pizza casera", descripcion = "Crea una pizza desde cero. Amasa la base, agrega salsa de tomate, queso y tus toppings favoritos, ¡y hornéala hasta que quede perfecta!", "Pizza Casera", "https://www.youtube.com/watch?v=crdtrzZj3fo&pp=ygUbcGl6emEgY2FzZXJhIGZhY2lsIHkgcmFwaWRh"),
                    Actividad(titulo = "Batido refrescante", descripcion = "Prepara un batido con frutas frescas, leche o yogurt, y un toque de miel. ¡Ideal para un día caluroso!","Batidos para un dia caluroso", "https://www.youtube.com/watch?v=qPDwGpmJSuE&pp=ygUSYmF0aWRvIHJlZnJlc2NhbnRl"),
                    Actividad(titulo = "Tostadas creativas", descripcion = "Prepara tostadas con ingredientes variados como aguacate, huevo, frutas o miel. ¡Combina sabores y hazlas únicas!","", ""),
                    Actividad(titulo = "Galletas caseras", descripcion = "Hornea galletas caseras con chocolate, avena o tus ingredientes favoritos. ¡El aroma te encantará!","Galletaaas!!!", "https://www.youtube.com/watch?v=SZdTJ6Ji3Ec&pp=ygUVZ2FsbGV0YXMgY2FzZXJhIGZhY2ls"),
                    Actividad(titulo = "Ensalada fresca", descripcion = "Crea una ensalada colorida mezclando vegetales frescos, frutas y un aderezo casero. ¡Llena tu plato de salud y sabor!","",""),
                    Actividad(titulo = "Sándwich especial", descripcion = "Prepara un sándwich diferente con panes, carnes, vegetales y salsas de tu elección. ¡Hazlo delicioso y original!","El sandwich perfecto","https://www.youtube.com/shorts/heOUSXlgsL0"),
                    Actividad(titulo = "Panqueques caseros", descripcion = "Haz panqueques esponjosos y decóralos con frutas, miel o chocolate. ¡Perfectos para un desayuno especial!","Panqueques Esponjosos","https://www.youtube.com/watch?v=JUeCNvCAnL8&pp=ygUScGFucXVlcXVlcyBjYXNlcm9z")
                )
            }
            "Musica" -> {//  Si el boton presionado tiene el nombre de "Musica" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Escribe una canción", descripcion = "Usa un cuaderno y escribe la letra de una canción. Agrega un ritmo básico golpeando la mesa o usando una aplicación musical.","",""),
                    Actividad(titulo = "Crea un playlist único", descripcion = "Selecciona tus canciones favoritas y crea un playlist que refleje tu estado de ánimo. ¡Perfecto para inspirarte o relajarte!","",""),
                    Actividad(titulo = "Dibuja tu música", descripcion = "Escucha una canción y dibuja lo que sientes o lo que te inspira. Transforma los sonidos en imágenes.","",""),
                    Actividad(titulo = "Improvisa con tu voz", descripcion = "Canta melodías libres sin seguir ninguna canción. Juega con tonos, ritmos y sonidos. ¡Deja que tu voz fluya!","",""),
                    Actividad(titulo = "Toca la guitarra básica", descripcion = "Si tienes una guitarra, aprende tres acordes simples y prueba tocarlos al ritmo de una canción fácil.","Cancion facil con 2 acordes","https://www.youtube.com/watch?v=0J59vrByWjw&pp=ygUaY2FuY2lvbiBmYWNpbCBjb24gZ3VpdGFycmE%3D"),
                    Actividad(titulo = "Explora el teclado", descripcion = "Practica melodías básicas en un teclado o piano. Comienza con canciones como 'Cumpleaños feliz' o 'Twinkle Twinkle'.","",""),
                    Actividad(titulo = "Ritmos con pandereta", descripcion = "Usa una pandereta o improvisa una con tapas de metal y crea ritmos sencillos acompañando tu canción favorita.","",""),
                    Actividad(titulo = "Sonidos con flauta", descripcion = "Si tienes una flauta dulce, aprende a tocar notas básicas y una melodía simple. ¡Es ideal para empezar!","","")
                )
            }
            "Poesia" -> {//  Si el boton presionado tiene el nombre de "Poesia" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Escribe un haiku", descripcion = "Crea un poema breve siguiendo la estructura del haiku: tres versos de 5, 7 y 5 sílabas. Inspírate en la naturaleza o en tus pensamientos.","",""),
                    Actividad(titulo = "Crea un acróstico", descripcion = "Elige una palabra especial y escribe un poema donde cada verso comience con una letra de esa palabra.","",""),
                    Actividad(titulo = "Describe tu día en versos", descripcion = "Escribe un poema corto que narre cómo ha sido tu día. Usa rimas o versos libres para expresar tus emociones.","",""),
                    Actividad(titulo = "Poesía de objetos", descripcion = "Elige un objeto cercano, como una taza o un lápiz, y escribe un poema describiéndolo de una manera única y creativa.","",""),
                    Actividad(titulo = "Poema inspirado en una canción", descripcion = "Escucha tu canción favorita y escribe un poema inspirado en su letra, ritmo o mensaje.","",""),
                    Actividad(titulo = "Carta poética", descripcion = "Escribe una carta en forma de poema para alguien especial. Expresa tus sentimientos con metáforas y rimas.","",""),
                    Actividad(titulo = "Reescribe un poema famoso", descripcion = "Elige un poema clásico y reescríbelo a tu estilo. Mantén el mensaje original o dale un giro creativo.","Conozco un lugar","https://www.scharrenberg.net/blog/2022/03/15/conozco-un-lugar/"),
                    Actividad(titulo = "Poema de cinco sentidos", descripcion = "Escribe un poema donde uses los cinco sentidos (vista, oído, tacto, olfato y gusto) para describir una escena o emoción.","",""),
                    Actividad(titulo = "Escribe una oda", descripcion = "Dedica un poema a algo simple que te guste, como el café, una mascota o una estación del año. ¡Hazlo sentir especial!","",""),
                    Actividad(titulo = "Poema de contraste", descripcion = "Escribe un poema que hable de dos emociones opuestas, como la alegría y la tristeza, o el día y la noche.","",""),
                    Actividad(titulo = "Improvisa versos con rimas", descripcion = "Escribe versos rápidos usando palabras que rimen entre sí. ¡No te preocupes por la perfección, diviértete creando!","","")
                )
            }
            "Aprendizaje" -> {//  Si el boton presionado tiene el nombre de "Aprendizaje" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Aprende 5 palabras nuevas en otro idioma", descripcion = "Elige un idioma que te interese y busca 5 palabras nuevas. Escríbelas, di su pronunciación y úsalas en oraciones simples.","",""),
                    Actividad(titulo = "Domina una fórmula matemática", descripcion = "Escoge una fórmula o concepto matemático. Aprende cómo se usa y resuelve 3 problemas aplicándola paso a paso.","",""),
                    Actividad(titulo = "Crea un mapa mental", descripcion = "Elige un tema que estés estudiando y haz un mapa mental que conecte ideas clave, conceptos y ejemplos. Usa colores y dibujos que te ayuden a recordarlo mejor.","",""),
                    Actividad(titulo = "Estudia con flashcards", descripcion = "Crea tarjetas de memoria (flashcards) con conceptos importantes. Son un buen metodo para aprender cosas nuevas, es muy usada para el estudio.","",""),
                    Actividad(titulo = "Investiga un dato curioso historico", descripcion = "Elige un evento histórico o personaje famoso, talvez ya tienes un favortio, y descubre un hecho interesante sobre él. Anótalo y compártelo con alguien.","Dato curioso","https://www.autopista.es/planeta2030/doce-curiosidades-historia_255516_102.html"),
                    Actividad(titulo = "Aprende una técnica de estudio nueva", descripcion = "Investiga técnicas como el Pomodoro, mapas conceptuales o resúmenes. Practica la técnica durante 25 minutos sobre un tema que te guste.","",""),
                    Actividad(titulo = "Identifica las partes de un sistema (cuerpo, máquina, etc.)", descripcion = "Elige un sistema específico: Humano o Maquina. Dibuja sus partes y nómbralas mientras describes su función.","",""),
                )
            }
            "Videojuegos" -> {//  Si el boton presionado tiene el nombre de "Videojuegos" entonces:
                list = mutableListOf(//Se llena la lista con los siguiente datos
                    //Actividades
                    Actividad(titulo = "Organiza un torneo con amigos", descripcion = "Elige tu videojuego favorito y organiza un torneo con amigos. Define las reglas, crea brackets y compite para ver quién es el campeón.","",""),
                    Actividad(titulo = "Completa un desafío en tu juego favorito", descripcion = "Selecciona un desafío difícil dentro de tu juego preferido, como completar todas las misiones secundarias","",""),
                    Actividad(titulo = "Crea tu propio mundo o nivel", descripcion = "Utiliza herramientas de creación en juegos como Minecraft, Roblox o Super Mario Maker para diseñar un mundo, nivel o escenario a tu gusto.","",""),
                    Actividad(titulo = "Juega en modo cooperativo", descripcion = "Elige un juego que tenga modo cooperativo y juega con un amigo o en línea. Algun juego tranquilo que no sea muy estresante.","",""),
                    Actividad(titulo = "Explora juegos retro", descripcion = "Busca juegos clásicos o retro y prueba cómo se jugaban antes. Comparte tu experiencia y descubre si aún son divertidos.","",""),
                    Actividad(titulo = "Graba tu gameplay y compártelo", descripcion = "Graba una partida interesante o divertida, edítala y compártela con tus amigos o en redes sociales. Agrega comentarios si lo prefieres.","",""),
                    Actividad(titulo = "Desbloquea logros o trofeos", descripcion = "Revisa los logros o trofeos de un juego y trata de completar la mayor cantidad posible. Algunos desafíos requieren mucha habilidad.","","")
                )
            }
            else -> {// Si no es ninguno de los anteriores entonces:
                println("Noodle") //imprime en la consola
            }
        }
        listaDeDatos.addAll(list)// Añadir todos los elementos de la lista "list" a la lista de datos mustable "listaDeDatos"
    }
    fun setUpRecyclerView(){//Añade al adaptador la "listaDeDatos"
        recyclerActivityAdapter.addDataToList(listaDeDatos)
        binding.communityRecyclerPosts.apply() {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recyclerActivityAdapter//Asignar el adaptador al RecyclerView
        }
    }
}