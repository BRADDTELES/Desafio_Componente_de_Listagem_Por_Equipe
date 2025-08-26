package com.equipe4.desafiocomponentedelistagem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.desafiocomponentedelistagem.databinding.ItemCategoriasPerfilBinding
import com.equipe4.desafiocomponentedelistagem.diffcallback.CategoriaDiffCallback
import com.equipe4.desafiocomponentedelistagem.model.Categorias

class CategoriaAdapter(

) : ListAdapter<Categorias, CategoriaAdapter.CategoriasViewHolder>(
    CategoriaDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriasViewHolder {
        val binding = ItemCategoriasPerfilBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriasViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoriasViewHolder,
        position: Int
    ) {
        val categoria = getItem(position)
        holder.bind(categoria)
    }

    inner class CategoriasViewHolder(private val binding: ItemCategoriasPerfilBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoria: Categorias) {

        }
    }
}