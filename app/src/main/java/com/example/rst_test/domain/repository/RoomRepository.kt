package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.RoomUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface RoomRepository {

   suspend fun getRoomsData(url: String): Flow<Result<List<RoomUiModel>>>
}