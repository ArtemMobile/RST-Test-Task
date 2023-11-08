package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.BlogRepository
import javax.inject.Inject

class GetBlogsDataUseCase @Inject constructor(private val blogRepository: BlogRepository) {

    suspend fun invoke(url: String) = blogRepository.getBlogsData(url)
}