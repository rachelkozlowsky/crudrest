package com.kazuweb.crudrest.rest.v1.controller

import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.rest.v1.api.ProductsApi
import com.kazuweb.crudrest.rest.v1.dto.ProductsDTO
import com.kazuweb.crudrest.rest.v1.dto.ProductsUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.ProductsView
import com.kazuweb.crudrest.service.impl.ProductsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController(
    private val productsService: ProductsService
) : ProductsApi {
    override fun findById(id: Long): ResponseEntity<ProductsView> {
        val products: Products = this.productsService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(ProductsView(products))
    }

    override fun saveProduct(productsDTO: ProductsDTO): ResponseEntity<String> {
        val savedProducts = this.productsService.save(productsDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Product ${savedProducts.productName} - Id:${savedProducts.productId} saved")
    }

    override fun updateProduct(id: Long, productsUpdateDTO: ProductsUpdateDTO): ResponseEntity<ProductsView> {
        val products: Products = this.productsService.findById(id)
        val productToUpdate: Products = productsUpdateDTO.toEntity(products)
        val productUpdated: Products = this.productsService.save(productToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(ProductsView(productUpdated))
    }

    override fun deleteProduct(id: Long) {
        this.productsService.delete(id)
    }
}