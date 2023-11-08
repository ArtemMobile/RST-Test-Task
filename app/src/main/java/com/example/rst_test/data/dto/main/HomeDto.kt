package com.example.rst_test.data.dto.main


import com.google.gson.annotations.SerializedName

data class HomeDto(
    @SerializedName("buttons")
    val buttons: List<Button>,
    @SerializedName("content")
    val content: List<Content>
)