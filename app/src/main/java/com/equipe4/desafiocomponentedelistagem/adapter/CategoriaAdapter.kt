package com.equipe4.desafiocomponentedelistagem.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.databinding.ItemCategoriasPerfilBinding
import com.equipe4.desafiocomponentedelistagem.diffcallback.CategoriaDiffCallback
import com.equipe4.desafiocomponentedelistagem.model.Categorias

class CategoriaAdapter(
    private val onClick: (categoria: Categorias, position: Int) -> Unit
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
        holder.bind(categoria, position)
    }

    inner class CategoriasViewHolder(private val binding: ItemCategoriasPerfilBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(categoria: Categorias, position: Int) {
            Glide.with(binding.imgIconeCategoria).load(categoria.icone).centerCrop().placeholder(R.drawable.fundo_perfil).into(binding.imgIconeCategoria)
            binding.tvNomeCategoria.text = categoria.nome
            binding.tvDescricaoCategoria.text = categoria.descricao

            if (categoria.isNotification == true){
                binding.imageView2.visibility = View.VISIBLE
                binding.tvNotificationCategoria.text = categoria.qtdNotification.toString()
            } else {
                binding.imageView2.visibility = View.GONE
                binding.tvNotificationCategoria.text = ""
            }

            if (position == 0) {
                binding.root.setOnClickListener { onClick(categoria, position) }
            } else {
                binding.root.setOnClickListener{onClick(categoria, position)}
                binding.root.isClickable = true
                /* --> Não faz nada, apenas desabilita o clique <--
                binding.root.setOnClickListener(null)
                binding.root.isClickable = false
                */
            }
        }
    }
}