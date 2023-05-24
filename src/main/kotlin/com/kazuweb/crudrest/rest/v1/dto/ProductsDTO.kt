package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Products
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class ProductsDTO(
    @field:NotEmpty(message = "campo não pode ser vazio")
    val productName: String,
    @field:NotNull(message = "campo deve estar preenchido")
    val productValue: BigDecimal
) {

    fun toEntity(): Products = Products(
        productName = this.productName,
        productValue = this.productValue,
    )
}
