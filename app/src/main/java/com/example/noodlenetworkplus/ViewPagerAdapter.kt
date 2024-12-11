package com.example.noodlenetworkplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val presentacionlist: List<Presentacion>
): RecyclerView.Adapter<ViewPagerAdapter.PresentacionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.presentacion_item, parent, false)
        return PresentacionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return presentacionlist.size
    }

    override fun onBindViewHolder(holder: PresentacionViewHolder, position: Int) {
        holder.bind(presentacionlist[position])
    }
    inner class PresentacionViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        private val container = itemView.findViewById<ViewGroup>(R.id.container)
        private val imagen = itemView.findViewById<ImageView>(R.id.imageView)
        private val titulo = itemView.findViewById<TextView>(R.id.textView_titulo)
        private val descripcion = itemView.findViewById<TextView>(R.id.textView_descrpcion)
        fun bind(presentacion: Presentacion){
            container.background = ContextCompat.getDrawable(container.context, presentacion.fondo)
            imagen.setImageResource(presentacion.image)
            titulo.text = presentacion.titulo
            descripcion.text = presentacion.descripcion

        }

    }
}