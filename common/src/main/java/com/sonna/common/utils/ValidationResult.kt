package com.sonna.common.utils

data class ValidationResult(
    val isValid: Boolean,
    val errorMessage: String = ""
)