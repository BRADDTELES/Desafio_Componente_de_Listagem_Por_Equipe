package com.equipe4.desafiocomponentedelistagem.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.equipe4.desafiocomponentedelistagem.model.ItemProdutoOpcionais

class ItemProutoOpcionaisDiffCallback : DiffUtil.ItemCallback<ItemProdutoOpcionais>() {
    override fun areItemsTheSame(
        oldItem: ItemProdutoOpcionais,
        newItem: ItemProdutoOpcionais
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ItemProdutoOpcionais,
        newItem: ItemProdutoOpcionais
    ): Boolean {
        return oldItem == newItem
    }
}