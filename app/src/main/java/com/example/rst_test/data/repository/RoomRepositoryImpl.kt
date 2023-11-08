package com.example.rst_test.data.repository

import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.RoomUiModel
import com.example.rst_test.domain.repository.RoomRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : RoomRepository {

    private fun getPeopleCountString(people: Int): String{
        val lastTwoDigits = (people % 1000) % 100
        return if((lastTwoDigits % 10 == 1 && lastTwoDigits > 20) || lastTwoDigits == 1)
            "До $people гостя"
        else
            "До $people гостей"
    }

    override suspend fun getRoomsData(url: String): Flow<Result<List<RoomUiModel>>> = flow {
        val response = apiService.getRoomsData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                   RoomUiModel(
                       dto.id,
                       getNightString(dto.duration.night),
                       dto.price.apply {
                           currency = convertCurrency(dto.price.currency)
                       },
                       dto.title,
                       getPeopleCountString(dto.countTourist),
                       dto.image.md
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
fun getNightString(night: Int): String {
    val lastTwoDigits = (night % 1000) % 100
    return  if(night == 1)
        "ночь"
    else if((lastTwoDigits % 10 == 1 && lastTwoDigits > 20) || lastTwoDigits == 1)
        "$night ночь"
    else if((lastTwoDigits % 10 in 2..4) && lastTwoDigits / 10 != 1)
        "$night ночи"
    else
        "$night ночей"
}

fun convertCurrency(currency: String): String{
    return when(currency){
        Currency.RUB.toString() -> "₽"
        else -> {"₽"}
    }
}

enum class Currency{
    RUB
}