package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class OrdersDTO(
    val paymentMethod: PaymentsMethod,
    val paymentValue: BigDecimal,
    val tax: BigDecimal?,
    val discount: BigDecimal?,
    val status: StatusOrder,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    var customerId: Long,
    val address: Address,
    val products: List<Products>,
) {
    fun toEntity(): Orders = Orders(
        paymentMethod = this.paymentMethod,
        paymentValue = this.paymentValue,
        tax = this.tax,
        discount = this.discount,
        status = this.status,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        customer = Customer(customerId = this.customerId),
        address = this.address,
        products = this.products,
    )
}
