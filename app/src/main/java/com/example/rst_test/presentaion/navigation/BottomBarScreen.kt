package com.example.rst_test.presentaion.navigation

import com.example.rst_test.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Home : BottomBarScreen(
        route = Graph.HOME,
        title = "Главная",
        icon = R.drawable.home_ic
    )

    object Map : BottomBarScreen(
        route = Graph.MAP,
        title = "Карты",
        icon = R.drawable.map_ic
    )

    object Booking : BottomBarScreen(
        route = Graph.BOOKING,
        title = "Бронь",
        icon = R.drawable.booking_ic
    )

    object Chat : BottomBarScreen(
        route = Graph.CHAT,
        title = "Чат",
        icon = R.drawable.chat_ic
    )

    object More : BottomBarScreen(
        route = Graph.MORE,
        title = "Ещё",
        icon = R.drawable.dots_ic
    )
}