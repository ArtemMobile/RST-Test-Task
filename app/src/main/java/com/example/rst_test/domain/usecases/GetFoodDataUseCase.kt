package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodDataUseCase @Inject constructor(private val foodRepository: FoodRepository) {

    suspend fun invoke(url: String) = foodRepository.getFoodData(url)
}