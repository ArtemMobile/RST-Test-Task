package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.FunUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface FunRepository {

   suspend fun getFunData(url: String): Flow<Result<List<FunUiModel>>>
}