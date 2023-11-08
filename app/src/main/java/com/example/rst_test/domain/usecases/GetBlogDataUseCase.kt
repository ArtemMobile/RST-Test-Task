package com.example.rst_test.domain.usecases

import com.example.rst_test.domain.repository.BlogRepository
import javax.inject.Inject

class GetBlogDataUseCase @Inject constructor(private val blogRepository: BlogRepository) {

    suspend fun invoke(idBlog: Int) = blogRepository.getBlogData(idBlog)
}