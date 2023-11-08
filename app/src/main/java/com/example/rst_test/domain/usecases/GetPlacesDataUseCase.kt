package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.PlaceRepository
import javax.inject.Inject

class GetPlacesDataUseCase @Inject constructor(private val placeRepository: PlaceRepository) {

    suspend fun invoke(url: String) = placeRepository.getPlacesData(url)
}