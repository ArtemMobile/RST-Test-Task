package com.example.rst_test.data.dto.tour

import com.example.rst_test.data.dto.common.ImageDto
import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("base")
    val base: Base,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("name")
    val name: String,
    @SerializedName("night")
    val night: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)