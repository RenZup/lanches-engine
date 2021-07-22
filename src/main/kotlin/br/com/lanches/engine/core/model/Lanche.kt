package br.com.lanches.engine.core.model

import java.util.*

data class Lanche(
    val nome: String,
    val ingredientes: String,
    val preco: Double,
    var id: UUID? = null

)