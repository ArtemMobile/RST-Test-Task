package com.example.rst_test.presentaion.main.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rst_test.presentaion.navigation.BottomBarScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarForScreen(screens: List<BottomBarScreen>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    currentDestination?.let {
        val title = screens.firstOrNull { screen -> screen.route == it.route }?.title
        if (title != null) {
            TopAppBar(title = {
                Text(text = title, fontSize = 20.sp)
            }, scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior())

        }
    }
}