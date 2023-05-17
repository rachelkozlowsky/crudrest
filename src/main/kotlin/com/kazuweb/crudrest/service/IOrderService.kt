package com.kazuweb.crudrest.service

import com.kazuweb.crudrest.domain.Orders
import java.util.UUID

interface IOrderService {

    fun save(orders: Orders): Orders

    fun findAllByCustomer(customerId: Long): List<Orders>

    fun findByOrderCode(orderCode: UUID): List<Orders>
}
