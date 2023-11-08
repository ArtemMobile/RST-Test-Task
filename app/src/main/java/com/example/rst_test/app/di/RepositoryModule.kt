package com.example.rst_test.app.di

import com.example.rst_test.data.repository.BlogRepositoryImpl
import com.example.rst_test.data.repository.FoodRepositoryImpl
import com.example.rst_test.data.repository.ForChildrenRepositoryImpl
import com.example.rst_test.data.repository.FunRepositoryImpl
import com.example.rst_test.data.repository.HomeRepositoryImpl
import com.example.rst_test.data.repository.PlaceRepositoryImpl
import com.example.rst_test.data.repository.RoomRepositoryImpl
import com.example.rst_test.data.repository.TourRepositoryImpl
import com.example.rst_test.domain.repository.BlogRepository
import com.example.rst_test.domain.repository.FoodRepository
import com.example.rst_test.domain.repository.ForChildrenRepository
import com.example.rst_test.domain.repository.FunRepository
import com.example.rst_test.domain.repository.HomeRepository
import com.example.rst_test.domain.repository.PlaceRepository
import com.example.rst_test.domain.repository.RoomRepository
import com.example.rst_test.domain.repository.TourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideFoodRepository(foodRepositoryImpl: FoodRepositoryImpl): FoodRepository

    @Binds
    fun provideHomeRepository(mainRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    fun provideBlogRepository(blogRepositoryImpl: BlogRepositoryImpl): BlogRepository

    @Binds
    fun provideForChildrenRepository(forChildrenRepositoryImpl: ForChildrenRepositoryImpl): ForChildrenRepository

    @Binds
    fun provideFunRepository(funRepositoryImpl: FunRepositoryImpl): FunRepository

    @Binds
    fun providePlaceRepository(placeRepositoryImpl: PlaceRepositoryImpl): PlaceRepository

    @Binds
    fun provideRoomRepository(roomRepositoryImpl: RoomRepositoryImpl): RoomRepository

    @Binds
    fun provideTourRepository(tourRepositoryImpl: TourRepositoryImpl): TourRepository

}