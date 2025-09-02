package com.equipe4.desafiocomponentedelistagem.model

data class ProdutosDestaque(
    val nome: String,
    val preco: String,
    val imagemResId: Int   // aqui você passa o id do drawable (ex: R.drawable.meu_produto)
)

