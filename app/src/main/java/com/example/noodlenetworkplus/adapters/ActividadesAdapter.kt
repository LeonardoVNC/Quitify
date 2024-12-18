package com.example.noodlenetworkplus.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noodlenetworkplus.dataClasses.Actividad
import com.example.noodlenetworkplus.databinding.ItemRecomendationActBinding

class ActividadesAdapter: RecyclerView.Adapter<ActividadesAdapter.ActividadViewHolder>(){
    private val datos = mutableListOf<Actividad>()  //Creacion de una lista de datos de tipo Actividades(data class)
    private var context: Context?=null

    inner class ActividadViewHolder(private val binding: ItemRecomendationActBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(data: Actividad) {
            binding.actTitle.text = data.titulo //Asigna el dato del data class Actividad "titulo" al texto del TextView del RecyclerView
            binding.actDesc.text = data.descripcion //Asigna el dato del data class Actividad "descripción" al texto del TextView del RecyclerView
            binding.actButtonLink.text = data.butontext //Asigna el dato del data class Actividad "buttonLink" al texto del Boton del RecyclerView
            binding.actButtonLink.setOnClickListener{ //Verifica si el boton con id "ButtonLink" fue presionado
                if(!data.url.isNullOrEmpty()){ //si el data.url no esta vacio:
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url)) // El intent redireccionará al URL registrado
                    itemView.context.startActivity(intent)
                }else{ //O imprimira que no hay enlace
                    println("no hay enlace")
                }
            }

        }
    }

    //Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadViewHolder {
        context = parent.context
        return ActividadViewHolder(
            ItemRecomendationActBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }
    //Tamaño de la lista respecto a la lista mutable "dato"
    override fun getItemCount(): Int = datos.size

    //Enlazar los datos al ViewHolder
    override fun onBindViewHolder(holder: ActividadViewHolder, position: Int) {
        holder.binding(datos[position])
    }
    //Actualización de la lista
    fun addDataToList(list:List<Actividad>){
        datos.clear()
        datos.addAll(list)
    }
}