package com.kazuweb.crudrest.domain

import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "Orders")
data class Orders(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val orderCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    var paymentMethod: PaymentsMethod = PaymentsMethod.DEBIT,
    @Column(nullable = false)
    var paymentValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = true)
    var tax: BigDecimal? = BigDecimal.ZERO,
    @Column(nullable = true)
    var discount: BigDecimal? = BigDecimal.ZERO,
    @Enumerated
    var status: StatusOrder = StatusOrder.PENDING,
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var customer: Customer = Customer(),
    @Embedded
    var address: Address = Address(),
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var products: List<Products> = mutableListOf(),

)

// todo: serialize time
// @JsonSerialize(using = LocalDateTimeSerializer::class)
// @JsonFormat(pattern = "yyyy-MM-dd")
// @JsonProperty("date")
