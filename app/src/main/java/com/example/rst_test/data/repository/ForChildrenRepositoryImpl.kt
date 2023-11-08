package com.example.rst_test.data.repository

import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.ChildUiModel
import com.example.rst_test.domain.repository.ForChildrenRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ForChildrenRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : ForChildrenRepository {

    override suspend fun getForChildrenData(url: String): Flow<Result<List<ChildUiModel>>> = flow {
        val response = apiService.getForChildrenData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                    ChildUiModel(
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