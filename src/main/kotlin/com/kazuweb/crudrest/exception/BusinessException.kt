package com.kazuweb.crudrest.exception

import java.lang.RuntimeException

data class BusinessException(
    override val message: String
) : RuntimeException(message)
