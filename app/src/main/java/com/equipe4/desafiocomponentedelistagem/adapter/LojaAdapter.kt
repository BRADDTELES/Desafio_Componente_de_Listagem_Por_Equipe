package com.equipe4.desafiocomponentedelistagem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.equipe4.desafiocomponentedelistagem.databinding.ItemRestauranteBinding
import com.equipe4.desafiocomponentedelistagem.diffcallback.LojaDiffCallback
import com.equipe4.desafiocomponentedelistagem.model.Loja

class LojaAdapter(
    private val onClick: (Loja) -> Unit
) : ListAdapter<Loja, LojaAdapter.LojaViewHolder>(LojaDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LojaViewHolder {
        val binding = ItemRestauranteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LojaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LojaViewHolder,
        position: Int
    ) {
        val loja = getItem(position)
        holder.bind(loja)
    }

    inner class LojaViewHolder(
        private val binding: ItemRestauranteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loja: Loja) {
            binding.tvNome.text = loja.nome
            binding.tvCategoria.text = loja.categoria
            binding.tvDistancia.text = loja.distancia
            binding.tvTempo.text = loja.tempo
            binding.tvPreco.text = "R$ %.2f".format(loja.preco)
            binding.tvAvaliacao.text = "%.1f".format(loja.avaliacao)

            Glide.with(binding.ivImagem)
                .load(loja.imagem)
                .centerCrop()
                .into(binding.ivImagem)

            // 👇 Aqui adicionamos o clique do item
            binding.root.setOnClickListener {
                onClick(loja)
            }
        }
    }
}
