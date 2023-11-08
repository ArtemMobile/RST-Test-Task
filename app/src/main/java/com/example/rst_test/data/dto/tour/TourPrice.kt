package com.example.rst_test.data.dto.tour

import com.google.gson.annotations.SerializedName

data class TourPrice(
    @SerializedName("currency")
    var currency: String,
    @SerializedName("factPrice")
    val factPrice: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("typePrice")
    val typePrice: String
)