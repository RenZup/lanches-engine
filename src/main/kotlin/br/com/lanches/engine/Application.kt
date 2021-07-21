package br.com.lanches.engine

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.lanches.engine")
		.start()
}

