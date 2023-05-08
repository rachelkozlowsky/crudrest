package com.kazuweb.crudrest.rest.v1.controller

import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.rest.v1.api.CustomerApi
import com.kazuweb.crudrest.rest.v1.dto.CustomerDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerView
import com.kazuweb.crudrest.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerService: CustomerService) : CustomerApi {

    override fun findById(id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    override fun saveCustomer(customerDTO: CustomerDTO): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved")
    }

    override fun updateCustomer(id: Long, customerUpdateDTO: CustomerUpdateDTO): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

    override fun deleteCustomer(id: Long) {
        fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
    }
}
