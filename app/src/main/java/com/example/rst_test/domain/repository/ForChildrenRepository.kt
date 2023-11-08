package com.example.rst_test.domain.repository

import com.example.rst_test.domain.model.ChildUiModel
import com.example.rst_test.utils.Result
import kotlinx.coroutines.flow.Flow

interface ForChildrenRepository {

   suspend fun getForChildrenData(url: String): Flow<Result<List<ChildUiModel>>>
}