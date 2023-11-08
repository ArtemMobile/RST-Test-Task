package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.PlaceUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {

   suspend fun getPlacesData(url: String): Flow<Result<List<PlaceUiModel>>>
}