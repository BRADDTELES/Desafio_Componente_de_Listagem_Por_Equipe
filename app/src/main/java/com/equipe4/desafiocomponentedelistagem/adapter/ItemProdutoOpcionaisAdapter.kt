package com.equipe4.desafiocomponentedelistagem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.databinding.ItemListaCarrinhoBinding
import com.equipe4.desafiocomponentedelistagem.diffcallback.ItemProutoOpcionaisDiffCallback
import com.equipe4.desafiocomponentedelistagem.model.ItemProdutoOpcionais

class ItemProdutoOpcionaisAdapter(
) : ListAdapter<ItemProdutoOpcionais, ItemProdutoOpcionaisAdapter.ItemProdutoOpcionaisViewHolder>(
    ItemProutoOpcionaisDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemProdutoOpcionaisViewHolder {
        val binding = ItemListaCarrinhoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemProdutoOpcionaisViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemProdutoOpcionaisViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ItemProdutoOpcionaisViewHolder(private val binding: ItemListaCarrinhoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemProdutoOpcionais) {
            binding.tvNomeProduto.text = item.nome
            binding.tvDescricaoProduto.text = item.descricao
            binding.tvPrecoProduto.text = "${"%.2f".format(item.preco)}"

            Glide.with(binding.imgProduto)
                .load(item.imagem)
                .centerCrop()
                .placeholder(R.drawable.nao_disponivel)
                .into(binding.imgProduto)
        }
    }

}