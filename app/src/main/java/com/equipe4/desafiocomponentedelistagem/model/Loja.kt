package com.equipe4.desafiocomponentedelistagem.model

data class Loja(
    val id: Int,
    val nome: String,
    val imagem: Int,
    val categoria: String,
    val avaliacao: Double,
    val distancia: String,
    val tempo: String,
    val preco: Double
)
