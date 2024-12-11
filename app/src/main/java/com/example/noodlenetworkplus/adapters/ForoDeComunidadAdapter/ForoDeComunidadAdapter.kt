package com.example.noodlenetworkplus.adapters.ForoDeComunidadAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.experimental.R
import androidx.recyclerview.widget.RecyclerView
import com.example.noodlenetworkplus.dataClasses.Publicacion
import com.example.noodlenetworkplus.databinding.ItemCommunityPostBinding

class ForoDeComunidadAdapter: RecyclerView.Adapter<ForoDeComunidadAdapter.PostViewHolder>() {
    private val datos = mutableListOf<Publicacion>()
    private var context:Context?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        context = parent.context
        return PostViewHolder(
            ItemCommunityPostBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount(): Int = datos.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding(datos[position])
    }

    inner class PostViewHolder(private val binding: ItemCommunityPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(data: Publicacion){
            binding.postTextAuthor.text = data.autor
            binding.postTextDate.text = data.fechaDePublicacion
            binding.postTextContent.text = data.contenido
            binding.postImageCategory.setImageResource(data.imagen)
        }
    }

    fun addDataToList(list: List<Publicacion>) {
        datos.clear()
        datos.addAll(list)
    }
}