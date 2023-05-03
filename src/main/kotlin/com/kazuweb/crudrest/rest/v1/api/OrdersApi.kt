package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.rest.v1.dto.OrdersDTO
import com.kazuweb.crudrest.rest.v1.dto.OrdersViewList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/orders")
interface OrdersApi {

    @PostMapping
    fun saveOrders(@RequestBody ordersDTO: OrdersDTO): String

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value= "customerId")customerId: Long): List<OrdersViewList>
}
