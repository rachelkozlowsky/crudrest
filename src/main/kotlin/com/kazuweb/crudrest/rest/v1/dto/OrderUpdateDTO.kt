package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderUpdateDTO(
    val paymentMethod: PaymentsMethod,
    @field:NotNull(message = "campo deve estar preenchido")
    val paymentValue: BigDecimal,
    val tax: BigDecimal?,
    val discount: BigDecimal?,
    val status: StatusOrder,
    @field:Future
    val updatedAt: LocalDateTime,
    val address: Address,
) {
    fun toEntity(orders: Orders): Orders {
        orders.paymentMethod = this.paymentMethod
        orders.paymentValue = this.paymentValue
        orders.tax = this.tax
        orders.discount = this.discount
        orders.status = this.status
        orders.updatedAt = this.updatedAt
        orders.address = this.address
        return orders
    }
}
