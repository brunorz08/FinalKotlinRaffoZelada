package com.example.finalraffozelada

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class RecetaAdapter(val context: Context) : ListAdapter<Receta, RecetaAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.textViewnombre)
        private val origen : TextView = view.findViewById(R.id.textVieworigen)
        private val dificultad: TextView = view.findViewById(R.id.textViewdificultad)



        fun bind (receta: Receta) {
            nombre.text =  receta.nombre.toString()
            dificultad.text = "Dificultad: " + receta.dificultad.toString()
            origen.text =  "Origen: " + receta.origen.toString()


            view.setOnClickListener {
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaAdapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}
