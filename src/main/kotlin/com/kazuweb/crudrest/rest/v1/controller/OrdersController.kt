package com.kazuweb.crudrest.rest.v1.controller

import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.rest.v1.api.OrdersApi
import com.kazuweb.crudrest.rest.v1.dto.OrdersDTO
import com.kazuweb.crudrest.rest.v1.dto.OrdersViewList
import com.kazuweb.crudrest.service.impl.OrdersService
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class OrdersController(
    private val ordersService: OrdersService,
) : OrdersApi {
    override fun saveOrders(ordersDTO: OrdersDTO): String {
        val order: Orders = this.ordersService.save(ordersDTO.toEntity())
        return "Order ${order.orderId} - Customer ${order.customer.cpf} saved"
    }

    override fun findAllByCustomerId(customerId: Long): List<OrdersViewList> {
        return this.ordersService.findAllByCustomer(customerId).stream().map {
                orders: Orders ->
            OrdersViewList(orders)
        }.collect(Collectors.toList())
    }
}
