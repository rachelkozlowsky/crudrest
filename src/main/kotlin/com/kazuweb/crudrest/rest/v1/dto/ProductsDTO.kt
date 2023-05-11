package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Products
import java.math.BigDecimal

data class ProductsDTO(
    val productName: String,
    val productValue: BigDecimal
) {

    fun toEntity(): Products = Products(
        productName = this.productName,
        productValue = this.productValue,
    )
}
