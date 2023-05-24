package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "campo não pode ser vazio")
    val firstName: String,
    @field:NotEmpty(message = "campo não pode ser vazio")
    val lastName: String,
    @field:NotEmpty(message = "campo não pode ser vazio")
    @field:CPF(message = "CPF invalido")
    val cpf: String,
    @field:NotEmpty(message = "campo não pode ser vazio")
    @field:Email(message = "e-mail invalido")
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
