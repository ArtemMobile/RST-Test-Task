package com.example.rst_test.data.dto.tour

import com.google.gson.annotations.SerializedName

data class TourDuration(
    @SerializedName("day")
    val day: Int,
    @SerializedName("night")
    val night: Int
)