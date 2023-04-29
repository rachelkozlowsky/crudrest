package com.kazuweb.crudrest.repository

import com.kazuweb.crudrest.domain.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository : JpaRepository<Products, Long>
