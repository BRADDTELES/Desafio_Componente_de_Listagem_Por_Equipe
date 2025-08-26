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
    private val onClick: (Categorias) -> Unit
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
        @SuppressLint("SetTextI18n")
        fun bind(categoria: Categorias) {
            Glide.with(binding.imgIconeCategoria).load(categoria.icone).centerCrop().placeholder(R.drawable.fundo_perfil).into(binding.imgIconeCategoria)
            binding.tvNomeCategoria.text = categoria.nome
            binding.tvDescricaoCategoria.text = categoria.descricao

            if (categoria.isNotification == true){
                binding.imageView2.visibility = View.VISIBLE
                binding.tvNotificationCategoria.text = "%.0f".format(categoria.qtdNotification)
            } else {
                binding.imageView2.visibility = View.GONE
                binding.tvNotificationCategoria.text = ""
            }

            binding.imgNavegar.setOnClickListener { onClick(categoria) }
        }
    }
}