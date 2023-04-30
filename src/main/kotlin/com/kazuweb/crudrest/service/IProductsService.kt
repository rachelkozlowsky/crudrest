package com.kazuweb.crudrest.service

import com.kazuweb.crudrest.domain.Products

interface IProductsService {

    fun save(products: Products): Products

    fun findById(id: Long): Products

    fun delete(id: Long)
}
