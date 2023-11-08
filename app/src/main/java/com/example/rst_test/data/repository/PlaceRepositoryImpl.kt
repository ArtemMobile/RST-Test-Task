package com.example.rst_test.data.repository

import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.PlaceUiModel
import com.example.rst_test.domain.repository.PlaceRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : PlaceRepository {
    override suspend fun getPlacesData(url: String): Flow<Result<List<PlaceUiModel>>> = flow {
        val response = apiService.getPlacesData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                    PlaceUiModel(
                        dto.id,
                        dto.image.md,
                        dto.subtitle,
                        dto.title
                    )
                }))
            }
        } else {
            emit(Result.Error(response.errorBody()?.string().toString()))
        }
    }.flowOn(Dispatchers.IO).catch {
        emit(Result.Error(it.message.toString()))
    }
}