package com.example.abdroidbase

import HomeScreen
import HomeSunFlower
import ReelsScreen
import SearchScreen
import ProfileScreen
import NotificationScreen
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavRoutes.HOME.route){
        composable(route = BottomNavRoutes.HOME.route){
            HomeSunFlower()
        }
        composable(route = BottomNavRoutes.SEARCH.route){
            SearchScreen()
        }
        composable(route = BottomNavRoutes.REELS.route){
            ReelsScreen()
        }
        composable(route = BottomNavRoutes.NOTIFICATIONS.route){
            NotificationScreen()
        }
        composable(route = BottomNavRoutes.PROFILE.route){
            ProfileScreen()
        }
    }
}