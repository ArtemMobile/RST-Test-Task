package com.example.rst_test.data.dto.tour

import com.google.gson.annotations.SerializedName

data class TourDate(
    @SerializedName("date")
    val date: String,
    @SerializedName("typeDate")
    val typeDate: String
)