package com.equipe4.desafiocomponentedelistagem.model

data class ItemProdutoOpcionais(
    val id: Int,
    val nome: String,
    val descricao: String? = null,
    val imagem: Int,
    val preco: Double,
)
