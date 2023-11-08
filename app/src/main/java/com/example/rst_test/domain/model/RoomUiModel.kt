package com.example.rst_test.domain.model

import com.example.rst_test.data.dto.room.RoomPrice

data class RoomUiModel(
    val id: Int,
    val duration: String,
    val price: RoomPrice,
    val title: String,
    val countTourist: String,
    val image: String,
)