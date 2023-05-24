package com.kazuweb.crudrest.rest.v1.dto

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF

data class CustomerDTO(

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
    @field:NotEmpty(message = "campo não pode ser vazio")
    val password: String,
    val address: Address,
) {
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
            complement = this.address.complement,
        ),
    )
}
