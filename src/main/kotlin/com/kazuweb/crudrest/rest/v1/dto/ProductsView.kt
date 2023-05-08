package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Products
import java.math.BigDecimal

class ProductsView(
    val productName: String,
    val productValue: BigDecimal,
) {
    constructor(products: Products) : this(
        productName = products.productName,
        productValue = products.productValue,
    )
}
