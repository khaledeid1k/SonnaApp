package com.sonna.domain.entity


sealed class ErrorType :Throwable(){
    class NetworkError :ErrorType()
    class ServerError : ErrorType()
    class UnKnownError :ErrorType()
}