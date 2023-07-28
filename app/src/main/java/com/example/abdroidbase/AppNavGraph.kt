package com.example.abdroidbase

import HomeScreen
import NotificationScreen
import ProfileScreen
import ReelsScreen
import SearchScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abdroidbase.enum.BottomNavRoutes

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavRoutes.HOME.route){
        composable(route = BottomNavRoutes.HOME.route){
            HomeScreen()
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