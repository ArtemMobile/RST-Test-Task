package com.example.rst_test.presentaion.home

import com.example.rst_test.utils.Result

fun Result<Any>.reduce(): HomeState {
    return when (this) {
        is Result.Error -> HomeState.Exception(error)
        is Result.Loading -> HomeState.Loading
        is Result.Success -> HomeState.Success(data)
    }
}