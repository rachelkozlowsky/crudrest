package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Products
import java.math.BigDecimal

class ProductsUpdateDTO(
    val productName: String,
    val productValue: BigDecimal,
) {
    fun toEntity(products: Products): Products {
        products.productName = this.productName
        products.productValue = this.productValue
        return products
    }
}
