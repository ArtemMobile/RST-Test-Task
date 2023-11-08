package com.example.rst_test.presentaion.home

import com.example.rst_test.domain.usecases.GetBlogsDataUseCase
import com.example.rst_test.domain.usecases.GetFoodDataUseCase
import com.example.rst_test.domain.usecases.GetForChildrenDataUseCase
import com.example.rst_test.domain.usecases.GetFunDataUseCase
import com.example.rst_test.domain.usecases.GetMainDataUseCase
import com.example.rst_test.domain.usecases.GetPlacesDataUseCase
import com.example.rst_test.domain.usecases.GetRoomsDataUseCase
import com.example.rst_test.domain.usecases.GetToursDataUseCase
import com.example.rst_test.presentaion.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsDataUseCase: GetBlogsDataUseCase,
    private val getFoodDataUseCase: GetFoodDataUseCase,
    private val getForChildrenDataUseCase: GetForChildrenDataUseCase,
    private val getFunDataUseCase: GetFunDataUseCase,
    private val getMainDataUseCase: GetMainDataUseCase,
    private val getPlacesDataUseCase: GetPlacesDataUseCase,
    private val getRoomsDataUseCase: GetRoomsDataUseCase,
    private val getToursDataUseCase: GetToursDataUseCase
) :
    BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    init {
        dispatchIntent(HomeIntent.LoadMainData)
    }

    private val _blogsState = MutableStateFlow<HomeState>(HomeState.Loading)
    val blogsState = _blogsState.asStateFlow()

    private val _foodState = MutableStateFlow<HomeState>(HomeState.Loading)
    val foodState = _foodState.asStateFlow()

    private val _forChildrenState = MutableStateFlow<HomeState>(HomeState.Loading)
    val forChildrenState = _forChildrenState.asStateFlow()

    private val _funState = MutableStateFlow<HomeState>(HomeState.Loading)
    val funState = _funState.asStateFlow()

    private val _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState = _homeState.asStateFlow()

    private val _placesState = MutableStateFlow<HomeState>(HomeState.Loading)
    val placesState = _placesState.asStateFlow()

    private val _roomsState = MutableStateFlow<HomeState>(HomeState.Loading)
    val roomsState = _roomsState.asStateFlow()

    private val _toursState = MutableStateFlow<HomeState>(HomeState.Loading)
    val toursState = _toursState.asStateFlow()

    protected override fun intentToAction(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.LoadFoodData -> HomeAction.GetFoodData(intent.url)
            is HomeIntent.LoadMainData -> HomeAction.GetMainData
            is HomeIntent.LoadBlogsData -> HomeAction.GetBlogsData(intent.url)
            is HomeIntent.LoadForChildrenData -> HomeAction.GetForChildrenData(intent.url)
            is HomeIntent.LoadFunData -> HomeAction.GetFunData(intent.url)
            is HomeIntent.LoadPlacesData -> HomeAction.GetPlacesData(intent.url)
            is HomeIntent.LoadRoomsData -> HomeAction.GetRoomsData(intent.url)
            is HomeIntent.LoadToursData -> HomeAction.GetToursData(intent.url)
        }
    }

    protected override fun handleAction(action: HomeAction) {
        launchOnUI {
            when (action) {
                is HomeAction.GetBlogsData -> getBlogsDataUseCase.invoke(action.url).collect {
                    _blogsState.value = it.reduce()
                }

                is HomeAction.GetForChildrenData -> getForChildrenDataUseCase.invoke(action.url).collect {
                        _forChildrenState.value = it.reduce()
                }

                is HomeAction.GetFunData -> getFunDataUseCase.invoke(action.url).collect {
                    _funState.value = it.reduce()
                }

                is HomeAction.GetFoodData -> getFoodDataUseCase.invoke(action.url).collect {
                    _foodState.value = it.reduce()
                }

                HomeAction.GetMainData -> getMainDataUseCase.invoke().collect {
                    _homeState.value = it.reduce()
                }

                is HomeAction.GetRoomsData -> getRoomsDataUseCase.invoke(action.url).collect {
                    _roomsState.value = it.reduce()
                }

                is HomeAction.GetToursData -> getToursDataUseCase.invoke(action.url).collect {
                    _toursState.value = it.reduce()
                }

                is HomeAction.GetPlacesData -> getPlacesDataUseCase.invoke(action.url).collect {
                    _placesState.value = it.reduce()
                }
            }
        }
    }
}