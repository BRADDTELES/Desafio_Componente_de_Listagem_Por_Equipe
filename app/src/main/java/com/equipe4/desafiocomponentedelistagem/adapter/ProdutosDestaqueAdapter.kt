package com.equipe4.desafiocomponentedelistagem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.model.ProdutosDestaque

class ProdutosDestaqueAdapter(
    private val itens: List<ProdutosDestaque>
) : RecyclerView.Adapter<ProdutosDestaqueAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagem: ImageView = view.findViewById(R.id.itemImage)
        val preco: TextView = view.findViewById(R.id.itemPrice)
        val nome: TextView = view.findViewById(R.id.itemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produtos_destaque, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = itens[position]
        holder.nome.text = produto.nome
        holder.preco.text = produto.preco
        holder.imagem.setImageResource(produto.imagemResId)
    }

    override fun getItemCount(): Int = itens.size
}
