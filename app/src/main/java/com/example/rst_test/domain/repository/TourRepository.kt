package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.TourUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface TourRepository {

   suspend fun getToursData(url: String): Flow<Result<List<TourUiModel>>>
}