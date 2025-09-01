package com.equipe4.desafiocomponentedelistagem.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.equipe4.desafiocomponentedelistagem.model.Categorias

class CategoriaDiffCallback : DiffUtil.ItemCallback<Categorias>() {
    override fun areItemsTheSame(
        oldItem: Categorias,
        newItem: Categorias
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Categorias,
        newItem: Categorias
    ): Boolean {
        return oldItem == newItem
    }
}