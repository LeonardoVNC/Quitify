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
            binding.actTitle.text = data.titulo
            binding.actDesc.text = data.descripcion
            binding.actButtonLink.text = data.butontext
            binding.actButtonLink.setOnClickListener{
                if(!data.url.isNullOrEmpty()){
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
                    itemView.context.startActivity(intent)
                }else{
                    println("no hay enlace")
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadViewHolder {
        context = parent.context
        return ActividadViewHolder(
            ItemRecomendationActBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount(): Int = datos.size

    override fun onBindViewHolder(holder: ActividadViewHolder, position: Int) {
        holder.binding(datos[position])
    }

    fun addDataToList(list:List<Actividad>){
        datos.clear()
        datos.addAll(list)
    }
}