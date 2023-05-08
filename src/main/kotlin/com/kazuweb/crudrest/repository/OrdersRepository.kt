package com.kazuweb.crudrest.repository

import com.kazuweb.crudrest.domain.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrdersRepository : JpaRepository<Orders, Long> {
    fun findByOrderCode(orderId: UUID): Orders

    @Query(value = "SELECT * FROM ORDERS WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Orders>
}
