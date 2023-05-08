package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.Products
import java.math.BigDecimal

class ProductsDTO(
    val productName: String,
    val productValue: BigDecimal,
    val orders: Orders,
) {

    fun toEntity(): Products = Products(
        productName = this.productName,
        productValue = this.productValue,
        orders = this.orders,
    )
}
