package com.example.rst_test.data.dto.main

import com.google.gson.annotations.SerializedName

data class Button(
    @SerializedName("color")
    val color: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)