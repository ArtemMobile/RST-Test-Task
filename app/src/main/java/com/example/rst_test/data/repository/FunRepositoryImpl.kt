package com.example.rst_test.data.repository

import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.FunUiModel
import com.example.rst_test.domain.repository.FunRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FunRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : FunRepository {
    override suspend fun getFunData(url: String): Flow<Result<List<FunUiModel>>> = flow {
        val response = apiService.getFunData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                    FunUiModel(
                        dto.id,
                        dto.image.sm,
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