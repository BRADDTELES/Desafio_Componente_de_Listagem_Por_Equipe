package com.equipe4.desafiocomponentedelistagem.model

data class Categorias(
    val id: Int,
    val nome: String,
    val descricao: String? = null,
    val icone: String,
    val isNotification: Boolean? = null,
    val qtdNotification: Int? = null
)
