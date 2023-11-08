package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.FunRepository
import javax.inject.Inject

class GetFunDataUseCase @Inject constructor(private val funRepository: FunRepository) {

    suspend fun invoke(url: String) = funRepository.getFunData(url)
}