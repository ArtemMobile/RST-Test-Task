package com.example.rst_test.presentaion.blog

import com.example.rst_test.presentaion.common.ViewIntent

sealed class BlogIntent : ViewIntent {
    class LoadBlogData(val id: Int) : BlogIntent()
}