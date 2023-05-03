package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer

data class CustomerDTO(

    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String,
    val address: Address,
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.address.zipCode,
            city = this.address.city,
            street = this.address.street,
            number = this.address.number,
            complement = this.address.complement
        )
    )
}
