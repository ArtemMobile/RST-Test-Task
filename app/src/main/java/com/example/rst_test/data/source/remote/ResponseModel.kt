package com.example.rst_test.data.source.remote

import com.google.gson.annotations.SerializedName

data class ResponseModel<T>(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: Any?,
    @SerializedName("time")
    val time: String,
    @SerializedName("data")
    val data: T
)