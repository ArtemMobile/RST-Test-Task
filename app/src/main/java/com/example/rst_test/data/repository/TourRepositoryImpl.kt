package com.example.rst_test.data.repository

import android.annotation.SuppressLint
import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.BlogUiModel
import com.example.rst_test.domain.model.TourUiModel
import com.example.rst_test.domain.repository.BlogRepository
import com.example.rst_test.domain.repository.TourRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TourRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : TourRepository {

    private fun getDayString(day: Int): String {
        val lastTwoDigits = (day % 1000) % 100
        return if ((lastTwoDigits % 10 == 1 && lastTwoDigits > 20) || lastTwoDigits == 1)
            "$day день "
        else if ((lastTwoDigits % 10 in 2..4) && lastTwoDigits / 10 != 1)
            "$day дня "
        else
            "$day дней "
    }

    private fun getDurationString(day: Int, night: Int): String {
        return getDayString(day) + getNightString(night)
    }

    override suspend fun getToursData(url: String): Flow<Result<List<TourUiModel>>> = flow {
        val response = apiService.getToursData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                    TourUiModel(
                        dto.id,
                        dto.image.md,
                        dto.title,
                        getDurationString(day = dto.duration.day, night = dto.duration.night),
                        dto.price.apply {
                            currency = convertCurrency(dto.price.currency)
                        },
                        dto.date.date
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