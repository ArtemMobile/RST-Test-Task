package com.example.rst_test.data.dto.blog

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.rst_test.data.dto.common.ImageDto
import com.example.rst_test.data.repository.convertLocalDateTimeToDate
import com.example.rst_test.domain.model.SingleBlogUiModel
import com.google.gson.annotations.SerializedName

data class SingleBlogDto(
    @SerializedName("content")
    val content: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("like")
    val like: Int,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)

@RequiresApi(Build.VERSION_CODES.O)
fun SingleBlogDtoToUi(blogDto: SingleBlogDto): SingleBlogUiModel{
    return  SingleBlogUiModel(
        blogDto.id,
        blogDto.image.lg,
        convertLocalDateTimeToDate(blogDto.date),
        blogDto.title,
        blogDto.content
    )
}