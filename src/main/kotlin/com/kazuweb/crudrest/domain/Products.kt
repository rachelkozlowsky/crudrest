package com.kazuweb.crudrest.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "Products")
data class Products(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productId: Long? = null,
    @Column(nullable = false)
    var productName: String = "",
    @Column(nullable = false)
    var productValue: BigDecimal = BigDecimal.ZERO
)
