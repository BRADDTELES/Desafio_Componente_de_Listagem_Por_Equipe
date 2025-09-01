package com.equipe4.desafiocomponentedelistagem.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.desafiocomponentedelistagem.R
import com.equipe4.desafiocomponentedelistagem.model.Produtos

class ProdutosAdapter(
    private val produtos: List<Produtos>,
    private val onItemClicked: (Produtos) -> Unit
) : RecyclerView.Adapter<ProdutosAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagem: ImageView = view.findViewById(R.id.imgProdutoItem)
        val nome: TextView = view.findViewById(R.id.txtProdutoNome)
        val descricao: TextView = view.findViewById(R.id.txtProdutoDescricao)
        val preco: TextView = view.findViewById(R.id.txtProdutoPreco)

        init {
            view.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    val produtoClicado = produtos[adapterPosition]
                    onItemClicked(produtoClicado)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produtos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.nome.text = produto.nome
        holder.descricao.text = produto.descricao
        holder.preco.text = produto.preco
        holder.imagem.setImageResource(produto.imagemResId)
    }

    override fun getItemCount(): Int = produtos.size
}
