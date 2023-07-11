package com.example.abdroidbase.widgets

import com.example.abdroidbase.R
import com.example.abdroidbase.enum.BottomNavRoutes


sealed class BottomNaves(
    val title: String,
    val icon: Int,
    val type: BottomNavRoutes,
    val route: String
) {
    object HOME: BottomNaves(title = "Home", icon = R.drawable.home, route = BottomNavRoutes.HOME.route, type = BottomNavRoutes.HOME)
    object SEARCH: BottomNaves(title = "Search", icon = R.drawable.search, route = BottomNavRoutes.SEARCH.route, type = BottomNavRoutes.SEARCH)
    object REELS: BottomNaves(title = "Reels", icon = R.drawable.video, route = BottomNavRoutes.REELS.route, type = BottomNavRoutes.REELS)
    object NOTIFICATIONS: BottomNaves(title = "Notifications", icon = R.drawable.love, route = BottomNavRoutes.NOTIFICATIONS.route, type = BottomNavRoutes.NOTIFICATIONS)
    object PROFILE: BottomNaves(title = "Profile", icon = R.drawable.user, route = BottomNavRoutes.PROFILE.route, type = BottomNavRoutes.PROFILE)
}