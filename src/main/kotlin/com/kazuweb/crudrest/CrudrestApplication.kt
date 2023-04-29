package com.kazuweb.crudrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudrestApplication

fun main(args: Array<String>) {
    runApplication<CrudrestApplication>(*args)
}
