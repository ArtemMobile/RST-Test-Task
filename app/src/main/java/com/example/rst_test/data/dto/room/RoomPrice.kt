package com.example.rst_test.data.dto.room

import com.google.gson.annotations.SerializedName

data class RoomPrice(
    @SerializedName("currency")
    var currency: String,
    @SerializedName("discount")
    val discount: Any,
    @SerializedName("factPrice")
    val factPrice: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("typePrice")
    val typePrice: String
)