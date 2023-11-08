package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.TourRepository
import javax.inject.Inject

class GetToursDataUseCase @Inject constructor(private val tourRepository: TourRepository) {

    suspend fun invoke(url: String) = tourRepository.getToursData(url)
}