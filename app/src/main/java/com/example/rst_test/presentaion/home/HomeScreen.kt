package com.example.rst_test.presentaion.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.rst_test.data.dto.main.Button
import com.example.rst_test.data.dto.main.HomeDto
import com.example.rst_test.domain.model.BlogUiModel
import com.example.rst_test.domain.model.ChildUiModel
import com.example.rst_test.domain.model.FoodUiModel
import com.example.rst_test.domain.model.FunUiModel
import com.example.rst_test.domain.model.PlaceUiModel
import com.example.rst_test.domain.model.RoomUiModel
import com.example.rst_test.domain.model.TourUiModel
import com.example.rst_test.presentaion.home.components.BlogItem
import com.example.rst_test.presentaion.home.components.ButtonItem
import com.example.rst_test.presentaion.home.components.ButtonItemShimmer
import com.example.rst_test.presentaion.home.components.FoodItem
import com.example.rst_test.presentaion.home.components.FoodShimmerItem
import com.example.rst_test.presentaion.home.components.ForChildrenItem
import com.example.rst_test.presentaion.home.components.FunItem
import com.example.rst_test.presentaion.home.components.PlaceItem
import com.example.rst_test.presentaion.home.components.RoomItem
import com.example.rst_test.presentaion.home.components.ShowAllButton
import com.example.rst_test.presentaion.home.components.ShowAllRow
import com.example.rst_test.presentaion.home.components.ShowAllRowShimmer
import com.example.rst_test.presentaion.home.components.TourItem
import com.example.rst_test.presentaion.navigation.Graph.BLOG
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
) {
    val homeState = homeViewModel.homeState.collectAsStateWithLifecycle()
    val foodState = homeViewModel.foodState.collectAsStateWithLifecycle()
    val roomsState = homeViewModel.roomsState.collectAsStateWithLifecycle()
    val funState = homeViewModel.funState.collectAsStateWithLifecycle()
    val forChildrenState = homeViewModel.forChildrenState.collectAsStateWithLifecycle()
    val toursState = homeViewModel.toursState.collectAsStateWithLifecycle()
    val placesState = homeViewModel.placesState.collectAsStateWithLifecycle()
    val blogState = homeViewModel.blogsState.collectAsStateWithLifecycle()
    val foodText = remember { mutableStateOf("") }
    val roomsText = remember { mutableStateOf("") }
    val funText = remember { mutableStateOf("") }
    val forChildrenText = remember { mutableStateOf("") }
    val toursText = remember { mutableStateOf("") }
    val placesText = remember { mutableStateOf("") }
    val blogsText = remember { mutableStateOf("") }
    val buttonsList = remember { mutableStateOf(listOf<Button>()) }

    LazyColumn(Modifier.fillMaxWidth()) {
        when (homeState.value) {
            is HomeState.Loading -> {
                item {
                    ButtonItemShimmer()
                }
            }

            is HomeState.Success -> {
                ((homeState.value as HomeState.Success).data as HomeDto).apply {
                    homeViewModel.dispatchIntent(HomeIntent.LoadFoodData(content[0].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadRoomsData(content[1].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadFunData(content[2].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadForChildrenData(content[3].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadToursData(content[4].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadPlacesData(content[5].url))
                    homeViewModel.dispatchIntent(HomeIntent.LoadBlogsData(content[6].url))
                    foodText.value = content[0].title
                    roomsText.value = content[1].title
                    funText.value = content[2].title
                    forChildrenText.value = content[3].title
                    toursText.value = content[4].title
                    placesText.value = content[5].title
                    blogsText.value = content[6].title
                    buttonsList.value = buttons
                }
            }


            is HomeState.Exception -> {
                Log.e("HOME_STATE_EXCEPTION", (homeState.value as HomeState.Exception).error)
            }
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(buttonsList.value) { button ->
                    ButtonItem(button = button, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        when (foodState.value) {
            is HomeState.Exception -> {
                Log.e("FOOD_STATE_EXCEPTION", (foodState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {
                item {
                    ShowAllRowShimmer()
                }
                items((1..5).toList()) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                            FoodShimmerItem()
                        }
                        Column(modifier = Modifier.fillMaxWidth(1f)) {
                            FoodShimmerItem()
                        }
                    }
                }
            }

            is HomeState.Success -> {
                val foodData = ((foodState.value as HomeState.Success).data as List<*>)
                item {
                    Text(
                        text = foodText.value,
                        style = Typography.headlineMedium,
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                    )
                }

                val data = foodData.windowed(2, 2, true)
                items(data) { food ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                            FoodItem(food = food[0] as FoodUiModel)
                        }
                        if (food.size > 1) {
                            Column(Modifier.fillMaxWidth(1f)) {
                                FoodItem(food = food[1] as FoodUiModel)
                            }
                        }
                    }
                }
                item {
                    ShowAllButton(foodData.size) {
                        homeViewModel.dispatchIntent(HomeIntent.LoadFoodData("https://rsttur.ru/api/base-app/fun?id=117&type=food"))
                    }
                }
            }
        }

        when (roomsState.value) {
            is HomeState.Exception -> {
                Log.e("ROOMS_STATE_EXCEPTION", (roomsState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                item {
                    Text(
                        text = roomsText.value,
                        style = Typography.headlineMedium,
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
                    )
                }
                val roomsData = ((roomsState.value as HomeState.Success).data as List<*>)
                items(roomsData) { room ->
                    RoomItem(item = room as RoomUiModel)
                }
                item {
                    ShowAllButton(roomsData.size)
                }
            }
        }

        when (funState.value) {
            is HomeState.Exception -> {
                Log.e("FUN_STATE_EXCEPTION", (funState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                val funData = ((funState.value as HomeState.Success).data as List<*>)
                item {
                    ShowAllRow(text = funText.value, size = funData.size, action = { })
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(start = 8.dp, end = 16.dp, bottom = 16.dp),
                        content = {
                            items(funData) {
                                FunItem(
                                    item = it as FunUiModel,
                                    Modifier
                                        .padding(start = 8.dp)
                                        .fillParentMaxWidth(.44f)
                                )
                            }
                        })
                }
            }
        }

        when (forChildrenState.value) {
            is HomeState.Exception -> {
                Log.e(
                    "FORCHILDREN_STATE_EXCEPTION",
                    (forChildrenState.value as HomeState.Exception).error
                )
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                item {
                    Text(
                        text = forChildrenText.value,
                        style = Typography.headlineMedium,
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                    )
                }
                val forChildrenData =
                    ((forChildrenState.value as HomeState.Success).data as List<*>)
                items(forChildrenData) { child ->
                    ForChildrenItem(item = child as ChildUiModel)
                }
                item {
                    ShowAllButton(forChildrenData.size)
                }
            }
        }

        when (toursState.value) {
            is HomeState.Exception -> {
                Log.e("TOURS_STATE_EXCEPTION", (toursState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                item {
                    Text(
                        text = toursText.value,
                        style = Typography.headlineMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                val toursData = ((toursState.value as HomeState.Success).data as List<*>)
                val data = toursData.windowed(2, 2, true)
                items(data) { tour ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                            TourItem(item = tour[0] as TourUiModel)
                        }
                        if (tour.size > 1) {
                            Column(Modifier.fillMaxWidth(1f)) {
                                TourItem(item = tour[1] as TourUiModel)
                            }
                        }
                    }
                }
                item {
                    ShowAllButton(toursData.size)
                }
            }

        }
        when (placesState.value) {
            is HomeState.Exception -> {
                Log.e("PLACES_STATE_EXCEPTION", (placesState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                val placesData = ((placesState.value as HomeState.Success).data as List<*>)
                item {
                    ShowAllRow(text = placesText.value, size = placesData.size) { }
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(start = 8.dp, end = 16.dp),
                        content = {
                            items(placesData) { place ->
                                PlaceItem(
                                    place = place as PlaceUiModel,
                                    Modifier
                                        .padding(start = 8.dp)
                                        .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                                        .fillParentMaxWidth(.84f)
                                        .background(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                )
                            }
                        })
                }
            }
        }

        when (blogState.value) {
            is HomeState.Exception -> {
                Log.e("BLOGS_STATE_EXCEPTION", (blogState.value as HomeState.Exception).error)
            }

            HomeState.Loading -> {}

            is HomeState.Success -> {
                val blogsData = ((blogState.value as HomeState.Success).data as List<*>)
                item {
                    ShowAllRow(text = blogsText.value, size = blogsData.size, action = { })
                }
                item {
                    LazyRow(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(end = 16.dp,  bottom = 16.dp), content = {
                        items(blogsData) { blog ->
                            BlogItem(
                                blog = blog as BlogUiModel,
                                Modifier
                                    .fillParentMaxWidth(.91f)
                                    .padding(start = 16.dp)
                                    .clickable {
                                        navController.navigate("$BLOG/${blog.id}")
                                    })
                        }
                    })
                }
            }
        }
    }
}
