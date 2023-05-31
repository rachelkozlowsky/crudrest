package com.kazuweb.crudrest.service.impl

import com.kazuweb.crudrest.domain.Products
import com.kazuweb.crudrest.exception.BusinessException
import com.kazuweb.crudrest.repository.ProductsRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal
import java.util.*

@ExtendWith(MockKExtension::class)
internal class ProductsServiceTest {

    @MockK private val productsRepository: ProductsRepository = mockk(relaxed = true)

    @InjectMockKs lateinit var productsService: ProductsService // = ProductsService(productsRepository)

    @Test
    fun `should create product`() {
        val productMock: Products = buildProduct()
        every { productsRepository.save(any()) } returns productMock
        val productActual: Products = productsService.save(productMock)
        Assertions.assertThat(productActual).isNotNull
        Assertions.assertThat(productActual).isSameAs(productMock)
        verify(exactly = 1) { productsRepository.save(productMock) }
    }

    @Test
    fun `should find product by id`() {
        val idMock: Long = Random().nextLong()
        val productMock: Products = buildProduct(productId = idMock)
        every { productsRepository.findById(idMock) } returns Optional.of(productMock)
        val productActual: Products = productsService.findById(idMock)
        Assertions.assertThat(productActual).isNotNull
        Assertions.assertThat(productActual).isExactlyInstanceOf(Products::class.java)
        Assertions.assertThat(productActual).isSameAs(productMock)
        verify(exactly = 1) { productsRepository.findById(idMock) }
    }

    @org.junit.Test
    fun `should not find product by invalid id and throw BussinessException`() {
        val productsService: ProductsService = ProductsService(productsRepository)
        val idMock: Long = Random().nextLong()
        every { productsRepository.findById(idMock) } returns Optional.empty()

        Assertions.assertThatExceptionOfType(BusinessException::class.java)
            .isThrownBy { productsService.findById(idMock) }
            .withMessage("id $idMock not found")
    }

    @Test
    fun `should delete product by id`() {
        val idMock: Long = Random().nextLong()
        val productMock: Products = buildProduct(productId = idMock)
        every { productsRepository.findById(idMock) } returns Optional.of(productMock)
        every { productsRepository.deleteById(idMock) } just runs

        productsService.delete(idMock)

        verify(exactly = 1) { productsRepository.deleteById(idMock) }
    }

    fun buildProduct(
        productId: Long = 1L,
        productName: String = "Livro",
        productValue: BigDecimal = BigDecimal.TEN,
    ) = Products(
        productId = productId,
        productName = productName,
        productValue = productValue,
    )
}
