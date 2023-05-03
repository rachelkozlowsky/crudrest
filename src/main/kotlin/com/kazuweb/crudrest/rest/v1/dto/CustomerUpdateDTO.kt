package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer

data class CustomerUpdateDTO(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val address: Address,
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.cpf = this.cpf
        customer.email = this.email
        customer.address.city = this.address.city
        customer.address.zipCode = this.address.zipCode
        customer.address.street = this.address.street
        customer.address.number = this.address.number
        customer.address.complement = this.address.complement
        return customer
    }
}
