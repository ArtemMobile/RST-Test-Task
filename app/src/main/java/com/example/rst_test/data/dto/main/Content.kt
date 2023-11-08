package com.example.rst_test.data.dto.main


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("template")
    val template: Template,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)