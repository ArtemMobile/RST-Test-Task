package com.example.rst_test.presentaion.home

import com.example.rst_test.presentaion.common.ViewIntent

sealed class HomeIntent : ViewIntent {
    class LoadBlogsData(val url: String) : HomeIntent()
    class LoadFoodData(val url: String) : HomeIntent()
    class LoadForChildrenData(val url: String) : HomeIntent()
    class LoadFunData(val url: String) : HomeIntent()
    object LoadMainData : HomeIntent()
    class LoadPlacesData(val url: String) : HomeIntent()
    class LoadRoomsData(val url: String) : HomeIntent()
    class LoadToursData(val url: String) : HomeIntent()
}