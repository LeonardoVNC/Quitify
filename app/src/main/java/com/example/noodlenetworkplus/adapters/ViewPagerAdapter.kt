package com.example.noodlenetworkplus.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.noodlenetworkplus.R
import com.example.noodlenetworkplus.RegisterTimeActivity
import com.example.noodlenetworkplus.dataClasses.Presentacion

class ViewPagerAdapter(
    private val presentacionlist: List<Presentacion>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<ViewPagerAdapter.PresentacionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.presentacion_item, parent, false)
        return PresentacionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return presentacionlist.size
    }

    override fun onBindViewHolder(holder: PresentacionViewHolder, position: Int) {
        holder.bind(presentacionlist[position], viewPager)
    }

    inner class PresentacionViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val container = itemView.findViewById<ViewGroup>(R.id.container)
        private val imagen = itemView.findViewById<ImageView>(R.id.imageView)
        private val titulo = itemView.findViewById<TextView>(R.id.textView_titulo)
        private val descripcion = itemView.findViewById<TextView>(R.id.textView_descripcion)
        private val botonEmpezar = itemView.findViewById<Button>(R.id.button_empezar)
        private val botonSiguiente = itemView.findViewById<Button>(R.id.button_siguiente)

        fun bind(presentacion: Presentacion, viewPager: ViewPager2) {
            container.background = ContextCompat.getDrawable(container.context, presentacion.fondo)
            imagen.setImageResource(presentacion.image)
            titulo.text = presentacion.titulo
            descripcion.text = presentacion.descripcion


            if (adapterPosition == presentacionlist.size - 1) {
                botonEmpezar.visibility = View.VISIBLE
                botonSiguiente.visibility = View.GONE
                botonEmpezar.setOnClickListener {
                    itemView.context.startActivity(
                        Intent(itemView.context, RegisterTimeActivity::class.java)
                    )
                }
            } else {
                botonEmpezar.visibility = View.GONE
                botonSiguiente.visibility = View.VISIBLE
                botonSiguiente.setOnClickListener {
                    viewPager.currentItem = adapterPosition + 1
                }
            }
        }
    }
}