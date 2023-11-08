package com.example.rst_test.data.dto.place

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class PlaceDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)