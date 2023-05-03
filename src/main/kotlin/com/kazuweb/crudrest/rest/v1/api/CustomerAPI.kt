package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.rest.v1.dto.CustomerDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerView
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/customers/")
interface CustomerAPI {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView

    @PostMapping
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO): String

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDTO: CustomerUpdateDTO,
    ): CustomerView

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long)
}
