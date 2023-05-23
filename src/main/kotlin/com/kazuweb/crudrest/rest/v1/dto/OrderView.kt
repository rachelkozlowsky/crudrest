package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import java.math.BigDecimal
import java.util.UUID

data class OrderView(
    //val id: Long?,
    val orderCode: UUID,
    val paymentMethod: PaymentsMethod,
    val paymentValue: BigDecimal,
    val tax: BigDecimal?,
    val discount: BigDecimal?,
    val status: StatusOrder,
    val address: Address,
    val products: List<Products>,
) {
    constructor(orders: Orders) : this(
  //      id = orders.id,
        orderCode = orders.orderCode,
        paymentMethod = orders.paymentMethod,
        paymentValue = orders.paymentValue,
        tax = orders.tax,
        discount = orders.discount,
        status = orders.status,
        address = orders.address,
        products = orders.products,
    )
}
