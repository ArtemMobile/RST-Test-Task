package com.example.rst_test.data.dto.food

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class FoodDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)