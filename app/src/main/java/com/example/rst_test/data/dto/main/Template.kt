package com.example.rst_test.data.dto.main


import com.google.gson.annotations.SerializedName

data class Template(
    @SerializedName("card")
    val card: String,
    @SerializedName("direction")
    val direction: String,
    @SerializedName("object")
    val objectX: String,
    @SerializedName("size")
    val size: String
)