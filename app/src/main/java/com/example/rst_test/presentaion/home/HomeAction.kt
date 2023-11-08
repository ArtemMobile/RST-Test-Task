package com.example.rst_test.presentaion.home

import com.example.rst_test.presentaion.common.ViewAction

sealed class HomeAction : ViewAction {
    class GetBlogsData(val url: String) : HomeAction()
    class GetFoodData(val url: String) : HomeAction()
    class GetForChildrenData(val url: String) : HomeAction()
    class GetFunData(val url: String) : HomeAction()
    object GetMainData: HomeAction()
    class GetPlacesData(val url: String) : HomeAction()
    class GetRoomsData(val url: String) : HomeAction()
    class GetToursData(val url: String) : HomeAction()
}