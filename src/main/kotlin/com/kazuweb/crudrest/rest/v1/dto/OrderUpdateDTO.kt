package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderUpdateDTO(
    val paymentMethod: PaymentsMethod,
    val paymentValue: BigDecimal,
    val tax: BigDecimal?,
    val discount: BigDecimal?,
    val status: StatusOrder,
    val updatedAt: LocalDateTime,
    val address: Address,
    val products: List<Products>,
) {
    fun toEntity(orders: Orders): Orders {
        orders.paymentMethod = this.paymentMethod
        orders.paymentValue = this.paymentValue
        orders.tax = this.tax
        orders.discount = this.discount
        orders.status = this.status
        orders.updatedAt = this.updatedAt
        orders.address = this.address
        orders.products = this.products
        return orders
    }
}
