package com.example.abdroidbase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(){
    Column {
        AppBar()
        StoriesSection()
        PostsSection()
    }
}
@Composable
fun AppBar(){}

@Composable
fun StoriesSection(){}

@Composable
fun PostsSection(){}