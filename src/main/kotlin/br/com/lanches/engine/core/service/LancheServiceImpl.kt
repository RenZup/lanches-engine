package br.com.lanches.engine.core.service

import br.com.lanches.engine.core.mapper.Convert
import br.com.lanches.engine.core.model.Lanche
import br.com.lanches.engine.core.port.LancheDatabasePort
import br.com.lanches.engine.core.port.LancheServicePort
import br.com.lanches.engine.database.entity.LancheEntity
import br.com.lanches.engine.entrypoint.dto.LancheDto
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LancheServiceImpl(private val database: LancheDatabasePort): LancheServicePort {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun findAll(): List<LancheDto> {
        logger.info("\ncore/service: Lista de todos os lanches solicitada")
        val lancheEntities = database.findAll()
        val lancheDtos = mutableListOf<LancheDto>()
        for(i:LancheEntity in lancheEntities){
            lancheDtos.add(Convert.lancheEntitytoLancheDto(i))
        }
        return lancheDtos


    }

    override fun findById(id: UUID): Optional<LancheDto> {
        logger.info("\ncore/service: Lanche de id '$id' solicitado")
        val possivelLancheEntity = database.findById(id)

        if(possivelLancheEntity.isEmpty) return Optional.empty()

        return Optional.of(
            Convert.lancheEntitytoLancheDto(possivelLancheEntity.get())
        )
    }


}