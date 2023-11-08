package com.example.rst_test.data.dto.tour

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class TourDto(
    @SerializedName("date")
    val date: TourDate,
    @SerializedName("duration")
    val duration: TourDuration,
    @SerializedName("home")
    val home: Home,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("location")
    val location: String,
    @SerializedName("price")
    val price: TourPrice,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)