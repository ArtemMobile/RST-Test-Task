package com.example.rst_test.presentaion.blog

import com.example.rst_test.presentaion.common.ViewAction

sealed class BlogAction : ViewAction {
    class GetBlogData(val id: Int) : BlogAction()
}