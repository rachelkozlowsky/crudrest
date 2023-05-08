package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.rest.v1.dto.ProductsDTO
import com.kazuweb.crudrest.rest.v1.dto.ProductsUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.ProductsView
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/products/")
interface ProductsApi {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ProductsView>

    @PostMapping
    fun saveProduct(@RequestBody productsDTO: ProductsDTO): ResponseEntity<String>

    @PatchMapping
    fun updateProduct(
        @RequestParam(value = "productId") id: Long,
        @RequestBody productsUpdateDTO: ProductsUpdateDTO,
    ): ResponseEntity<ProductsView>

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long)
}
