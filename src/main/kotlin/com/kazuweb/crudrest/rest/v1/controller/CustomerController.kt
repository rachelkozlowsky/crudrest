package com.kazuweb.crudrest.rest.v1.controller

import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.rest.v1.api.CustomerAPI
import com.kazuweb.crudrest.rest.v1.dto.CustomerDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerView
import com.kazuweb.crudrest.service.impl.CustomerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerService: CustomerService) : CustomerAPI {

    override fun findById(id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    override fun saveCustomer(customerDTO: CustomerDTO): String {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return "Customer ${savedCustomer.email} saved"
    }

    override fun updateCustomer(id: Long, customerUpdateDTO: CustomerUpdateDTO): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }

    override fun deleteCustomer(id: Long) {
        fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
    }
}
