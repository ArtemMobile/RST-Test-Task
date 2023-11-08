package com.example.rst_test.presentaion.home

import com.example.rst_test.presentaion.common.ViewState

sealed class HomeState : ViewState {
    object Loading : HomeState()
    data class Success(val data : Any): HomeState()
    data class Exception(val error: String) : HomeState()
}