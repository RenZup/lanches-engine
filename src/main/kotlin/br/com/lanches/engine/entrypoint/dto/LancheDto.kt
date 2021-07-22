package br.com.lanches.engine.entrypoint.dto

import java.util.*

data class LancheDto(
    val nome: String,
    val ingredientes: String,
    val preco: Double,
    val id: UUID?

)