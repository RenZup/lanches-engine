package br.com.lanches.engine.database

import br.com.lanches.engine.core.model.Lanche
import br.com.lanches.engine.core.port.LancheDatabasePort
import br.com.lanches.engine.database.entity.LancheEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class LancheDatabaseImpl(private val cqlSession: CqlSession) : LancheDatabasePort {
    override fun findAll(): List<LancheEntity> {
        val result = cqlSession.execute(SimpleStatement.newInstance("SELECT * FROM lanche"))
        val listaLanches= mutableListOf<LancheEntity>()
        for (i: Row in result) {
            val nome = i.getString("nome") ?: ""
            val ingredientes = i.getString("ingredientes") ?: ""
            val preco = i.getDouble("preco")
            val id = i.getUuid("id")
            listaLanches.add(LancheEntity(nome,ingredientes,preco,id))
        }
        return listaLanches
    }

    override fun findById(id: UUID): Optional<LancheEntity> {
       val result = cqlSession.execute(SimpleStatement.newInstance("SELECT * FROM lanche WHERE id = ?",id))
        if(result.none()) return Optional.empty<LancheEntity>()
        //depois de lutar e apanhar de ResultSets de um unico resultado, Renzo fez uma gambiarra
        val possivelLanche = mutableListOf<LancheEntity>()
        for(i:Row in result){
            val nome = i.getString("nome") ?: ""
            val ingredientes = i.getString("ingredientes")?: ""
            val preco = i.getDouble("preco")
            val id = i.getUuid("id")
            possivelLanche.add(LancheEntity(nome,ingredientes,preco,id))
        }

        return Optional.of(
           possivelLanche.first())
    }

}