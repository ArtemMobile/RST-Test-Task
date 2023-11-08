package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.ForChildrenRepository
import javax.inject.Inject

class GetForChildrenDataUseCase @Inject constructor(private val childrenRepository: ForChildrenRepository) {

    suspend fun invoke(url: String) = childrenRepository.getForChildrenData(url)
}