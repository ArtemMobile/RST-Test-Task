package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.HomeRepository
import javax.inject.Inject

class GetMainDataUseCase @Inject constructor(private val mainRepository: HomeRepository) {

    suspend fun invoke() = mainRepository.getMainData()
}