package com.example.rst_test.presentaion.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rst_test.presentaion.blog.BlogScreen
import com.example.rst_test.presentaion.home.HomeScreen
import com.example.rst_test.presentaion.navigation.Graph.BLOG
import com.example.rst_test.presentaion.navigation.NavigationArgs.BLOG_ID
import com.example.rst_test.presentaion.other.OtherScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                navController = navController,
                homeViewModel = hiltViewModel(),
            )
        }
        composable(route = BottomBarScreen.Map.route) {
            OtherScreen()
        }

        composable(route = BottomBarScreen.Booking.route) {
            OtherScreen()
        }
        composable(route = BottomBarScreen.Chat.route) {
            OtherScreen()
        }
        composable(route = BottomBarScreen.More.route) {
            OtherScreen()
        }
        composable(route = "$BLOG/{$BLOG_ID}") { navBackStackEntry ->
            val idBlog = navBackStackEntry.arguments?.getString(BLOG_ID)
            idBlog?.let {
                BlogScreen(
                    navController = navController,
                    idBlog = it.toInt(),
                    blogViewModel = hiltViewModel()
                )
            }
        }
    }
}