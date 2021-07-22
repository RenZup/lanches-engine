package br.com.lanches.engine.core.mapper

import br.com.lanches.engine.database.entity.LancheEntity
import br.com.lanches.engine.entrypoint.dto.LancheDto

class Convert {
    companion object{
        fun lancheEntitytoLancheDto(lancheEntity: LancheEntity) = with(lancheEntity){
            LancheDto(nome,ingredientes,preco,id)
        }

    }
}