package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.domain.Orders
import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.domain.enuns.PaymentsMethod
import com.kazuweb.crudrest.domain.enuns.StatusOrder
import com.kazuweb.crudrest.repository.OrdersRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@ExtendWith(MockKExtension::class)
internal class OrdersServiceTest {

    @MockK
    lateinit var ordersRepository: OrdersRepository // = mockk(relaxed = true)

    @MockK
    lateinit var customerService: CustomerService // = mockk(relaxed = true)

    @InjectMockKs
    lateinit var ordersService: OrdersService // = OrdersService(ordersRepository, customerService)

    @Test
    fun `should create order`() {
        // todo: 1 terminar testes unitários
//        val orderMock: Orders = buildOrder()
//        every { ordersRepository.save(any()) } returns orderMock
//        val customerMock: Customer = customerService.findById(orderMock.customer.customerId!!)
//        val customerActual: Customer = customerService.save(customerMock)
//        val orderActual: Orders = ordersService.save(orderMock)
//        Assertions.assertThat(orderActual).isNotNull
//        Assertions.assertThat(customerActual).isNotNull
    }

    @Test
    fun findAllByCustomer() {
    }

    @Test
    fun findByOrderCode() {
    }

    @Test
    fun findById() {
    }

    @Test
    fun delete() {
    }

    fun buildOrder(
        id: Long? = 1L,
        orderCode: UUID = UUID.randomUUID(),
        paymentMethod: PaymentsMethod = PaymentsMethod.DEBIT,
        paymentValue: BigDecimal = BigDecimal.TEN,
        tax: BigDecimal? = BigDecimal.ZERO,
        discount: BigDecimal? = BigDecimal.ZERO,
        status: StatusOrder = StatusOrder.PENDING,
        createdAt: LocalDateTime = LocalDateTime.now(),
        updatedAt: LocalDateTime = LocalDateTime.now(),
        customerId: Long? = 1L,
        firstName: String = "Rachel",
        lastName: String = "Lima",
        cpf: String = "09551105729",
        email: String = "rachelkozlowsky@gmail.com",
        password: String = "123456",
        zipCode: String = "23530610",
        city: String = "Rio de Janeiro",
        street: String = "Estrada do Piai",
        number: String = "4264",
        complement: String = "casa",
        productId: Long = 1L,
        productName: String = "Livro",
        productValue: BigDecimal = BigDecimal.TEN,
    ) = Orders(
        id = id,
        orderCode = orderCode,
        paymentMethod = paymentMethod,
        paymentValue = paymentValue,
        tax = tax,
        discount = discount,
        status = status,
        createdAt = createdAt,
        updatedAt = updatedAt,
        customer = Customer(
            customerId = customerId,
            firstName = firstName,
            lastName = lastName,
            cpf = cpf,
            email = email,
            password = password,
            address = Address(
                zipCode = zipCode,
                city = city,
                street = street,
                number = number,
                complement = complement,
            ),
        ),
        products = listOf(
            Products(
                productId = productId,
                productName = productName,
                productValue = productValue,
            ),
        ),

    )
}
