package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.repository.OrdersRepository
import com.kazuweb.crudrest.service.IOrderService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OrdersService(
    private val ordersRepository: OrdersRepository,
    private val customerService: CustomerService,
) : IOrderService {

    override fun save(orders: Orders): Orders {
        orders.apply {
            customer = customerService.findById(orders.customer.customerId!!)
        }
        return this.ordersRepository.save(orders)
    }

    override fun findAllByCustomer(customerId: Long): List<Orders> =
        this.ordersRepository.findAllByCustomerId(customerId)

    override fun findByOrderCode(orderCode: UUID): List<Orders> =
        this.ordersRepository.findByOrderCode(orderCode)

    // return this.ordersRepository.findByOrderCode(orderCode) // ?: throw RuntimeException("Order $orderCode not found")
    // if (orders.customer.customerId == customerId) orders else throw RuntimeException("Contact Admin")
}
