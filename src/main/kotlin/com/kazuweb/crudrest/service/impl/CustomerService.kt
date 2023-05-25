package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.exception.BusinessException
import com.kazuweb.crudrest.repository.CustomerRepository
import com.kazuweb.crudrest.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
) : ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("id $id not found")
        }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}
