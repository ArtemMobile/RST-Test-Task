package com.example.rst_test.presentaion.blog

import com.example.rst_test.domain.usecases.GetBlogDataUseCase
import com.example.rst_test.domain.usecases.GetBlogsDataUseCase
import com.example.rst_test.presentaion.common.BaseViewModel
import com.example.rst_test.presentaion.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val getBlogDataUseCase: GetBlogDataUseCase
) : BaseViewModel<BlogIntent, BlogAction, BlogState>() {

    private val _blogState = MutableStateFlow<BlogState>(BlogState.Loading)
    val blogState = _blogState.asStateFlow()

    protected override fun intentToAction(intent: BlogIntent): BlogAction {
        return when (intent) {
            is BlogIntent.LoadBlogData -> BlogAction.GetBlogData(intent.id)
        }
    }

    protected override fun handleAction(action: BlogAction) {
        launchOnUI {
            when (action) {
                is BlogAction.GetBlogData -> getBlogDataUseCase.invoke(action.id).collect {
                    _blogState.value = it.reduceBlog()
                }
            }
        }
    }
}