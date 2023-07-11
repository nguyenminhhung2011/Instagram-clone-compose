package com.example.abdroidbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.abdroidbase.ui.theme.AbdroidBaseTheme
import com.example.abdroidbase.widgets.BottomNaves

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbdroidBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {BottomNavBar(navController)},
        backgroundColor = Color.White
    ) {
        AppNavGraph(navHostController = navController)
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navEntry?.destination
    val screens = listOf<BottomNaves>(
        BottomNaves.HOME,
        BottomNaves.SEARCH,
        BottomNaves.REELS,
        BottomNaves.NOTIFICATIONS,
        BottomNaves.PROFILE
    )

    BottomNavigation() {
        screens.forEach { screen -> 
            BottomNavigationItem(
                selected = currentDestination?.route == screen.route ,
                onClick = {navController.navigate(screen.route)},
                icon = {
                    Icon(painter = painterResource(id = screen.icon), contentDescription = "nav_icon", modifier = Modifier.size(24.dp))
                },
                modifier = Modifier.background(color = Color.White),
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black
            )
        }
    }
}
