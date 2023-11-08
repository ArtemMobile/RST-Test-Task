package com.example.rst_test.domain.repository

import com.example.rst_test.data.dto.main.HomeDto
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

   suspend fun getMainData(): Flow<Result<HomeDto>>
}