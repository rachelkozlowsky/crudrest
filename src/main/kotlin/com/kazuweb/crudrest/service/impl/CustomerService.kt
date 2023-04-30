package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.repository.CustomerRepository
import com.kazuweb.crudrest.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("id $id not found")
            // todo customizar exceção
        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)
}
