package com.example.rst_test.presentaion.blog

import com.example.rst_test.presentaion.common.ViewState

sealed class BlogState: ViewState {
    object Loading : BlogState()
    data class Success(val data : Any): BlogState()
    data class Exception(val error: String) : BlogState()
}