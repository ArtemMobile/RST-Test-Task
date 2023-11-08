package com.example.rst_test.data.dto.room

import com.google.gson.annotations.SerializedName

data class RoomDuration(
    @SerializedName("night")
    val night: Int
)