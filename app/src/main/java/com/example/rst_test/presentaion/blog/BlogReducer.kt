package com.example.rst_test.presentaion.blog
import com.example.rst_test.utils.Result

fun Result<Any>.reduceBlog(): BlogState {
    return when (this) {
        is Result.Error -> BlogState.Exception(error)
        is Result.Loading -> BlogState.Loading
        is Result.Success -> BlogState.Success(data)
    }
}