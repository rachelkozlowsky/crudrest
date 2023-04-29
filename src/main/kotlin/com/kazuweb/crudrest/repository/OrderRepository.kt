package com.kazuweb.crudrest.repository

import com.kazuweb.crudrest.domain.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Orders, Long>
