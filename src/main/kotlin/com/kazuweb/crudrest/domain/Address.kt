package com.kazuweb.crudrest.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(nullable = false)
    var zipCode: String = "",
    @Column(nullable = false)
    var city: String = "",
    @Column(nullable = false)
    var street: String = "",
    @Column(nullable = false)
    var number: String = "",
    @Column(nullable = false)
    var complement: String = "",
)
