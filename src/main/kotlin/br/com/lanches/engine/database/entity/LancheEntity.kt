package br.com.lanches.engine.database.entity

import java.util.*

data class LancheEntity(
    val nome: String,
    val ingredientes: String,
    val preco: Double,
    var id: UUID? = null

)