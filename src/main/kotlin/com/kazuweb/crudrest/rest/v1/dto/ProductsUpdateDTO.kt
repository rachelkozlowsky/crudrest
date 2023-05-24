package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Products
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class ProductsUpdateDTO(
    @field:NotEmpty(message = "campo não pode ser vazio")
    val productName: String,
    @field:NotNull(message = "campo deve estar preenchido")
    val productValue: BigDecimal,
) {
    fun toEntity(products: Products): Products {
        products.productName = this.productName
        products.productValue = this.productValue
        return products
    }
}
