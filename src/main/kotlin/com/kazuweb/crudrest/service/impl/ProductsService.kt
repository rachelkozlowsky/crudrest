package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.exception.BusinessException
import com.kazuweb.crudrest.repository.ProductsRepository
import com.kazuweb.crudrest.service.IProductsService
import org.springframework.stereotype.Service

@Service
class ProductsService(
    private val productsRepository: ProductsRepository,
) : IProductsService {

    override fun save(products: Products): Products =
        this.productsRepository.save(products)

    override fun findById(id: Long): Products =
        this.productsRepository.findById(id).orElseThrow {
            throw BusinessException("id $id not found")
        }

    override fun delete(id: Long) = this.productsRepository.deleteById(id)
}
