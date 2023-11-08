package com.example.rst_test.domain.model

import com.example.rst_test.data.dto.tour.TourPrice

data class TourUiModel(
    val id: Int,
    val image: String,
    val title: String,
    val duration: String,
    val price: TourPrice,
    val date: String
)