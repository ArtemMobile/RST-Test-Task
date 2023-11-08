package com.example.rst_test.data.source.remote.service

import com.example.rst_test.data.dto.blog.BlogDto
import com.example.rst_test.data.dto.blog.SingleBlogDto
import com.example.rst_test.data.dto.child.ChildDto
import com.example.rst_test.data.dto.entertainment.FunDto
import com.example.rst_test.data.dto.food.FoodDto
import com.example.rst_test.data.dto.main.HomeDto
import com.example.rst_test.data.dto.place.PlaceDto
import com.example.rst_test.data.dto.room.RoomDto
import com.example.rst_test.data.dto.tour.TourDto
import com.example.rst_test.data.source.remote.ApiConstants.BLOG_ID_PARAM
import com.example.rst_test.data.source.remote.ApiConstants.BLOG_INFO_ENDPOINT
import com.example.rst_test.data.source.remote.ApiConstants.ID_PARAM
import com.example.rst_test.data.source.remote.ApiConstants.MAIN_ENDPOINT
import com.example.rst_test.data.source.remote.ResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface TourApiService {

    @GET(MAIN_ENDPOINT)
    suspend fun getMainData(@Query(ID_PARAM) id: Int = 117): Response<ResponseModel<HomeDto>>

    @GET
    suspend fun getFoodData(@Url url: String): Response<ResponseModel<List<FoodDto>>>

    @GET
    suspend fun getBlogsData(@Url url: String): Response<ResponseModel<List<BlogDto>>>

    @GET
    suspend fun getForChildrenData(@Url url: String): Response<ResponseModel<List<ChildDto>>>

    @GET
    suspend fun getFunData(@Url url: String): Response<ResponseModel<List<FunDto>>>

    @GET
    suspend fun getPlacesData(@Url url: String): Response<ResponseModel<List<PlaceDto>>>

    @GET
    suspend fun getRoomsData(@Url url: String): Response<ResponseModel<List<RoomDto>>>

    @GET
    suspend fun getToursData(@Url url: String): Response<ResponseModel<List<TourDto>>>

    @GET(BLOG_INFO_ENDPOINT)
    suspend fun getBlogData(@Query ("id") id: Int = 117, @Query(BLOG_ID_PARAM) blogId: Int): Response<ResponseModel<SingleBlogDto>>

}