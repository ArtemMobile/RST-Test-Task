package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.BlogUiModel
import com.example.rst_test.domain.model.SingleBlogUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface BlogRepository {

   suspend fun getBlogsData(url: String): Flow<Result<List<BlogUiModel>>>

   suspend fun getBlogData(idBlog: Int): Flow<Result<SingleBlogUiModel>>
}