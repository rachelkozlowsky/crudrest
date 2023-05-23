package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.rest.v1.dto.OrderUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.OrderView
import com.kazuweb.crudrest.rest.v1.dto.OrdersDTO
import com.kazuweb.crudrest.rest.v1.dto.OrdersViewList
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@RequestMapping("/api/orders")
interface OrdersApi {

    @GetMapping("/id")
    fun findById(@RequestParam(value = "orderId")id: Long): ResponseEntity<OrderView>

    @PostMapping
    fun saveOrders(@RequestBody ordersDTO: OrdersDTO): ResponseEntity<String>

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId")customerId: Long): ResponseEntity<List<OrdersViewList>>

    @GetMapping("/{orderCode}")
    fun findByOrderCode(
        @PathVariable orderCode: UUID,
    ): ResponseEntity<List<OrderView>>

    @PatchMapping
    fun updateOrder(
        @RequestParam(value = "orderId") id: Long,
        @RequestBody orderUpdateDTO: OrderUpdateDTO,
    ): ResponseEntity<OrderView>

    @DeleteMapping("{id}")
    fun deleteOrder(@PathVariable id: Long): ResponseEntity<Void>
}
