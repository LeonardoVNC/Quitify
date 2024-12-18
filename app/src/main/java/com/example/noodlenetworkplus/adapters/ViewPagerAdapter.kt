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
import com.example.noodlenetworkplus.RegisterAdictionActivity
import com.example.noodlenetworkplus.RegisterTimeActivity
import com.example.noodlenetworkplus.dataClasses.Presentacion

// Adaptador para ViewPager2 que muestra una lista de presentaciones
class ViewPagerAdapter(
    private val presentacionlist: List<Presentacion>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<ViewPagerAdapter.PresentacionViewHolder>() {
    // Inflar el layout para cada elemento del ViewPager2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.presentacion_item, parent, false)
        return PresentacionViewHolder(view)
    }

    // Retorna el número total de elementos en la lista
    override fun getItemCount() = presentacionlist.size

    // Vincula los datos de la posición actual con la vista
    override fun onBindViewHolder(holder: PresentacionViewHolder, position: Int) {
        holder.bind(presentacionlist[position])
    }

    // ViewHolder para manejar cada página del ViewPager
    inner class PresentacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val container = itemView.findViewById<ViewGroup>(R.id.container)
        private val imagen = itemView.findViewById<ImageView>(R.id.imageView)
        private val titulo = itemView.findViewById<TextView>(R.id.textView_titulo)
        private val descripcion = itemView.findViewById<TextView>(R.id.textView_descripcion)
        private val botonEmpezar = itemView.findViewById<Button>(R.id.button_empezar)
        private val botonSiguiente = itemView.findViewById<Button>(R.id.button_siguiente)

        fun bind(presentacion: Presentacion) {
            container.background = ContextCompat.getDrawable(container.context, presentacion.fondo)
            imagen.setImageResource(presentacion.image)
            titulo.text = presentacion.titulo
            descripcion.text = presentacion.descripcion

            // Si es la última página, mostrar el botón "Empezar" y ocultar el botón "Siguiente"
            if (adapterPosition == presentacionlist.lastIndex) {
                botonEmpezar.apply {
                    visibility = View.VISIBLE
                    setOnClickListener {
                        // Iniciar la actividad RegisterAdictionActivity al hacer clic en "Empezar"
                        itemView.context.startActivity(Intent(itemView.context, RegisterAdictionActivity::class.java))
                    }
                }
                botonSiguiente.visibility = View.GONE
            } else {
                // Si no es la última página, mostrar el botón "Siguiente" y ocultar el botón "Empezar"
                botonSiguiente.apply {
                    visibility = View.VISIBLE
                    setOnClickListener { viewPager.currentItem = adapterPosition + 1 }
                }
                // Avanzar a la siguiente página del ViewPager2
                botonEmpezar.visibility = View.GONE
            }
        }
    }
}