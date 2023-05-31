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
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
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

    @RelaxedMockK
    lateinit var customerService: CustomerService // = mockk(relaxed = true)

    @InjectMockKs
    lateinit var ordersService: OrdersService // = OrdersService(ordersRepository, customerService)

    @Test
    fun `should create order`() {
        val orderMock: Orders = buildOrder()
        every { ordersRepository.save(any()) } returns orderMock
        val orderActual: Orders = ordersService.save(orderMock)
        Assertions.assertThat(orderActual).isNotNull
        Assertions.assertThat(orderActual).isSameAs(orderMock)
        verify(exactly = 1) { ordersRepository.save(orderMock) }
    }

    @Test
    fun `should find order by customerId`() {
        val customerIdMock: Long = Random().nextLong()
        val orderMock: Orders = buildOrder(customerId = customerIdMock)
        every { ordersRepository.findAllByCustomerId(any()) } returns listOf(orderMock)
        val orderActual: List<Orders> = ordersService.findAllByCustomer(customerIdMock)
        val list = convert(orderActual)
        Assertions.assertThat(orderActual).isNotNull
        Assertions.assertThat(list).isExactlyInstanceOf(Orders::class.java)
        verify(exactly = 1) { ordersRepository.findAllByCustomerId(customerIdMock) }
    }

    @Test
    fun `should find order by orderCode`() {
        val orderCodeMock: UUID = UUID.randomUUID()
        val orderMock: Orders = buildOrder(orderCode = orderCodeMock)
        every { ordersRepository.findByOrderCode(any()) } returns listOf(orderMock)
        val orderActual: List<Orders> = ordersService.findByOrderCode(orderCodeMock)
        val list = convert(orderActual)
        Assertions.assertThat(orderActual).isNotNull
        Assertions.assertThat(list).isExactlyInstanceOf(Orders::class.java)
        verify(exactly = 1) { ordersRepository.findByOrderCode(orderCodeMock) }
    }

    @Test
    fun findById() {
        // todo: test
    }

    @Test
    fun `should delete customer by id`() {
        // todo: test
    }

    @Test
    fun `a practise to convert varargs to list`() {
        /**
         * Converts the given parameters to a list.
         */
        fun <T> convert(vararg params: T): List<T> {
            val result = ArrayList<T>()

            params.forEach { result.add(it) }

            return result
        }

        // when
        val list = convert("A", "B", "C")

        // then
        assertTrue(list is List<String>)
        assertEquals(3, list.size)
        assertTrue("A" in list)
        assertTrue("B" in list)
        assertTrue("C" in list)
    }

    fun <T> convert(vararg params: T): Orders {
        val result = Orders()
        params.forEach { result.let { it } }
        return result
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
    ): Orders = Orders(
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
