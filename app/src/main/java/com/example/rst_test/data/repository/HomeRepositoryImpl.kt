package com.example.rst_test.data.repository

import com.example.rst_test.data.dto.main.HomeDto
import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.repository.HomeRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : HomeRepository {
    override suspend fun getMainData(): Flow<Result<HomeDto>> = flow {
        emit(Result.Loading)
        val response = apiService.getMainData()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data))
            }
        } else {
            emit(Result.Error(response.errorBody()?.string().toString()))
        }
    }.flowOn(Dispatchers.IO).catch {
        emit(Result.Error(it.message.toString()))
    }
}