package com.example.rst_test.presentaion.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rst_test.presentaion.main.components.BottomBar
import com.example.rst_test.presentaion.main.components.TopAppBarForScreen
import com.example.rst_test.presentaion.navigation.BottomBarScreen
import com.example.rst_test.presentaion.navigation.MainNavGraph

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Map,
        BottomBarScreen.Booking,
        BottomBarScreen.Chat,
        BottomBarScreen.More,
    )
    Scaffold(
        bottomBar = { BottomBar(screens, navController = navController) },
        topBar = { TopAppBarForScreen(screens, navController = navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    bottom = paddingValues.calculateBottomPadding(),
                    top = paddingValues.calculateTopPadding()
                )
        ) {
            MainNavGraph(navController = navController)
        }
    }
}


