package com.example.rst_test.data.dto.common

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("lg")
    val lg: String,
    @SerializedName("md")
    val md: String,
    @SerializedName("sm")
    val sm: String
)