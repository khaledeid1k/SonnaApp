package com.sonna.common.bases

import com.sonna.common.utils.ValidationResult

sealed class BaseErrorUiState(val message: String) {
    class Disconnected(error: String) : BaseErrorUiState(error)
    class UnAuthorized(val validationResults: List<ValidationResult>) :
        BaseErrorUiState("Invalid Input")

    class ServerError(error: String) : BaseErrorUiState(error)
    class NoFoundError(error: String) : BaseErrorUiState(error)
}
