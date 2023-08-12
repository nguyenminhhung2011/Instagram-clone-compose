package com.example.abdroidbase

import BottomNaves
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.abdroidbase.ui.theme.AbdroidBaseTheme

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
                    if(screen.type == BottomNavRoutes.PROFILE){
                        CircleAvatarView(avatarUrl = "")
                    }
                    else{
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = "nav_icon",
                            modifier = Modifier.size(22.dp)
                        )
                    }
                },
                modifier = Modifier.background(color = Color.White),
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black
            )
        }
    }
}

@Composable
fun CircleAvatarView(avatarUrl: String){
    Image(painter = painterResource(id = R.drawable.profile),
        contentDescription = "current_user",
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview(showBackground = true)
fun AppBar() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Image(painter = painterResource(id = R.drawable.instagram), contentDescription = "logo" )
    }
}

@Composable
fun ProfileView(){
    CircleAvatarView(avatarUrl = "")
}
