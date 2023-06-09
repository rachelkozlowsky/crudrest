package com.kazuweb.crudrest.rest.v1.api

import com.kazuweb.crudrest.rest.v1.dto.CustomerDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerUpdateDTO
import com.kazuweb.crudrest.rest.v1.dto.CustomerView
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/api/customers")
interface CustomerApi {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView>

    @PostMapping
    fun saveCustomer(
        @RequestBody @Valid
        customerDTO: CustomerDTO,
    ): ResponseEntity<String>

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody @Valid
        customerUpdateDTO: CustomerUpdateDTO,
    ): ResponseEntity<CustomerView>

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Void>
}
