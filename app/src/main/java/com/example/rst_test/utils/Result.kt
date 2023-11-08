package com.example.rst_test.utils

sealed class Result<out T> {
    object Loading : Result<Nothing>()

    data class Error(val error: String) : Result<Nothing>()

    data class Success<out T>(val data: T) : Result<T>()
}