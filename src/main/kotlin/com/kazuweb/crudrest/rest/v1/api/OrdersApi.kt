package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.rest.v1.dto.OrderView
import com.kazuweb.crudrest.rest.v1.dto.OrdersDTO
import com.kazuweb.crudrest.rest.v1.dto.OrdersViewList
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@RequestMapping("/api/orders")
interface OrdersApi {

    @PostMapping
    fun saveOrders(@RequestBody ordersDTO: OrdersDTO): ResponseEntity<String>

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId")customerId: Long): ResponseEntity<List<OrdersViewList>>

    @GetMapping("/{orderCode}")
    fun findByOrderCode(
        @PathVariable orderCode: UUID,
    ): ResponseEntity<Orders>
}
