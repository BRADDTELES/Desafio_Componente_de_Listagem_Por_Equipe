package com.equipe4.desafiocomponentedelistagem.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.equipe4.desafiocomponentedelistagem.model.Loja

class LojaDiffCallback : DiffUtil.ItemCallback<Loja>() {
    override fun areItemsTheSame(
        oldItem: Loja,
        newItem: Loja
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Loja,
        newItem: Loja
    ): Boolean {
        return oldItem == newItem
    }

}