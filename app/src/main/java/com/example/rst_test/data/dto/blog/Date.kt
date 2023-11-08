package com.example.rst_test.data.dto.blog

import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("date")
    val date: String,
    @SerializedName("typeDate")
    val typeDate: String
)