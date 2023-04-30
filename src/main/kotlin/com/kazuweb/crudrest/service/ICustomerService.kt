package com.kazuweb.crudrest.service

import com.kazuweb.crudrest.domain.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}