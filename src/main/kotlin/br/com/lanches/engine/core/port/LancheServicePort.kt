package br.com.lanches.engine.core.port

import br.com.lanches.engine.entrypoint.dto.LancheDto
import java.util.*

interface LancheServicePort{
    fun findAll(): List<LancheDto>
    fun findById(id: UUID): Optional<LancheDto>
}