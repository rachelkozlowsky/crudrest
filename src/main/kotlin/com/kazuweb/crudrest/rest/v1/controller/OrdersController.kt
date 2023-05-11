package com.kazuweb.crudrest.rest.v1.controller

import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.rest.v1.api.OrdersApi
import com.kazuweb.crudrest.rest.v1.dto.OrderView
import com.kazuweb.crudrest.rest.v1.dto.OrdersDTO
import com.kazuweb.crudrest.rest.v1.dto.OrdersViewList
import com.kazuweb.crudrest.service.impl.OrdersService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
class OrdersController(
    private val ordersService: OrdersService,
) : OrdersApi {
    override fun saveOrders(ordersDTO: OrdersDTO): ResponseEntity<String> {
        val order: Orders = this.ordersService.save(ordersDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Order ${order.orderCode} - Customer ${order.customer.cpf} saved")
    }

    override fun findAllByCustomerId(customerId: Long): ResponseEntity<List<OrdersViewList>> {
        val ordersViewList: List<OrdersViewList> = this.ordersService.findAllByCustomer(customerId).stream().map {
                orders: Orders ->
            OrdersViewList(orders)
        }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(ordersViewList)
    }

    override fun findByOrderCode(orderCode: UUID): ResponseEntity<Orders> {
        val order = this.ordersService.findByOrderCode(orderCode)
        return ResponseEntity.status(HttpStatus.OK).body(order)
        //todo: dando erro
    }

    // todo: update status order
}
