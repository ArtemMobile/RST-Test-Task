package com.example.rst_test.data.dto.tour

import com.google.gson.annotations.SerializedName

data class Base(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)