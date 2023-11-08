package com.example.rst_test.data.dto.room

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class RoomDto(
    @SerializedName("countTourist")
    val countTourist: Int,
    @SerializedName("date")
    val date: RoomDate,
    @SerializedName("duration")
    val duration: RoomDuration,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("price")
    val price: RoomPrice,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)