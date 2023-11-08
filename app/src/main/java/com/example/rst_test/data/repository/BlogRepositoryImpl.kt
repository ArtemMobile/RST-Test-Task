package com.example.rst_test.data.repository

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.rst_test.data.dto.blog.SingleBlogDtoToUi
import com.example.rst_test.data.source.remote.service.TourApiService
import com.example.rst_test.domain.model.BlogUiModel
import com.example.rst_test.domain.model.SingleBlogUiModel
import com.example.rst_test.domain.repository.BlogRepository
import com.example.rst_test.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val apiService: TourApiService
) : BlogRepository {

    override suspend fun getBlogsData(url: String): Flow<Result<List<BlogUiModel>>> = flow {
        val response = apiService.getBlogsData(url)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it.data.map { dto ->
                   BlogUiModel(
                       dto.id,
                       dto.image.lg,
                       dto.title,
                       convertDateTimeToDate(dto.date.date),
                   )
                }))
            }
        } else {
            emit(Result.Error(response.errorBody()?.string().toString()))
        }
    }.flowOn(Dispatchers.IO).catch {
        emit(Result.Error(it.message.toString()))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getBlogData(idBlog: Int): Flow<Result<SingleBlogUiModel>> = flow{
        val response = apiService.getBlogData(blogId = idBlog)
        if(response.isSuccessful){
            response.body()?.let {
                emit(Result.Success(SingleBlogDtoToUi(blogDto = it.data)))
            }
        } else{
            emit(Result.Error(response.errorBody()?.string().toString()))
        }
    }.flowOn(Dispatchers.IO).catch {
        emit(Result.Error(it.message.toString()))
    }
}

@SuppressLint("SimpleDateFormat")
private fun convertDateTimeToDate(date: String): String{
    val parsedDate: Date = SimpleDateFormat("yyyy-MM-dd").parse(date)
    val dateFormatter = SimpleDateFormat("d MMMM", Locale("ru"))
    return dateFormatter.format(parsedDate)
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertLocalDateTimeToDate(date: String): String {
    val input = OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(input)
}