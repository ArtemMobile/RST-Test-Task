package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.FoodUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FoodRepository {

   suspend fun getFoodData(url: String): Flow<Result<List<FoodUiModel>>>
}