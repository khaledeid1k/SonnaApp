package com.sonna.domain.entity

sealed class ErrorType :Throwable(){
    class NetworkError():ErrorType()
    class UnKnownError():ErrorType()
}