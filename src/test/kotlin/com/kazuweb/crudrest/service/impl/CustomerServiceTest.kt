package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Address
import com.kazuweb.crudrest.domain.Customer
import com.kazuweb.crudrest.exception.BusinessException
import com.kazuweb.crudrest.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

// @ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
open class CustomerServiceTest {

    @MockK private val customerRepository: CustomerRepository = mockk(relaxed = true)

    @InjectMockKs private val customerService: CustomerService = CustomerService(customerRepository)

//    @BeforeEach
//    fun setUp() {
//        MockKAnnotations.init(this)
//        // clearAllMocks()
//    }

    @Test
    fun `should create customer`() {
        val customerMock: Customer = buildCustomer()
        every { customerRepository.save(any()) } returns customerMock

        val customerActual: Customer = customerService.save(customerMock)

        Assertions.assertThat(customerActual).isNotNull
        Assertions.assertThat(customerActual).isSameAs(customerMock)
        verify(exactly = 1) { customerRepository.save(customerMock) }
    }

    @Test
    fun `should find customer by id`() {
        val idMock: Long = Random().nextLong()
        val customerMock: Customer = buildCustomer(customerId = idMock)
        every { customerRepository.findById(idMock) } returns Optional.of(customerMock)

        val customerActual: Customer = customerService.findById(idMock)

        Assertions.assertThat(customerActual).isNotNull
        Assertions.assertThat(customerActual).isExactlyInstanceOf(Customer::class.java)
        Assertions.assertThat(customerActual).isSameAs(customerMock)
        verify(exactly = 1) { customerRepository.findById(idMock) }
    }

    @Test
    fun `should not find customer by invalid id and throw BussinessException`() {
        val idMock: Long = Random().nextLong()
        every { customerRepository.findById(idMock) } returns Optional.empty()

        Assertions.assertThatExceptionOfType(BusinessException::class.java)
            .isThrownBy { customerService.findById(idMock) }
            .withMessage("id $idMock not found")
    }

    @Test
    fun `should delete customer by id`() {
        val idMock: Long = Random().nextLong()
        val customerMock: Customer = buildCustomer(customerId = idMock)
        every { customerRepository.findById(idMock) } returns Optional.of(customerMock)
        every { customerRepository.delete(customerMock) } just runs

        customerService.delete(idMock)

        verify(exactly = 1) { customerRepository.findById(idMock) }
        verify(exactly = 1) { customerRepository.delete(customerMock) }
    }

    // todo: implementar fixfixtures
    fun buildCustomer(
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
    ) = Customer(
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

    )
}
