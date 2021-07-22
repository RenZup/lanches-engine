package br.com.lanches.engine.core.port

import br.com.lanches.engine.database.entity.LancheEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface LancheDatabasePort {
    fun findAll(): List<LancheEntity>
    fun findById(id: UUID): Optional<LancheEntity>
}
