package com.example.rst_test.data.dto.blog

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class BlogDto(
    @SerializedName("date")
    val date: Date,
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
    @SerializedName("view")
    val view: Int
)