package br.com.lanches.engine.entrypoint.controller

import br.com.lanches.engine.core.port.LancheServicePort
import br.com.lanches.engine.entrypoint.dto.LancheDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.*

@Controller("/lanches")
class LancheController(private val service: LancheServicePort) {

    @Get
    fun findAll(): MutableHttpResponse<List<LancheDto>>? {
        return HttpResponse.ok(service.findAll())
    }

    @Get("/{id}")
    fun findById(@PathVariable id: UUID): MutableHttpResponse<LancheDto>? {
        val possivelLanche = service.findById(id)
        if(possivelLanche.isEmpty)return HttpResponse.notFound()
        return HttpResponse.ok(possivelLanche.get())
    }



}