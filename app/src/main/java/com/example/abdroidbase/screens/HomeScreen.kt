package com.example.abdroidbase.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.abdroidbase.R
import com.example.abdroidbase.model.Stories

@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar()
        StoriesSection(listStories = getStories())
        Divider(Modifier.fillMaxWidth().padding(vertical = 5.dp).height(2.dp))
        PostsSection()
    }
}

fun getStories() = listOf<Stories>(
    Stories(userName = "Hung", profile = R.drawable.profile),
    Stories(userName = "Hung", profile = R.drawable.profile),
    Stories(userName = "Hung", profile = R.drawable.profile),
    Stories(userName = "Hung", profile = R.drawable.profile),
    Stories(userName = "Hung", profile = R.drawable.profile),
    Stories(userName = "Hung", profile = R.drawable.profile),
)


@Composable
fun AppBar(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Image(painter = painterResource(id = R.drawable.instagram), contentDescription = "logo", modifier = Modifier
            .width(150.dp)
            .height(50.dp)
            .align(Alignment.TopStart))
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Image(painter = painterResource(id = R.drawable.more), contentDescription = "create_post", modifier = Modifier
                .size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(painter = painterResource(id = R.drawable.love), contentDescription = "create_post", modifier = Modifier
                .size(22.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(painter = painterResource(id = R.drawable.chat), contentDescription = "create_post", modifier = Modifier
                .size(23.dp)
            )
        }
    }
}

@Composable
fun StoriesSection(listStories: List<Stories>){
    LazyRow(modifier = Modifier.padding(start = 10.dp)){
        items(items = listStories){
            story -> StoryItem(modifier = Modifier, stories =story )
        }
    }
}

@Composable
fun StoryItem(modifier: Modifier, stories: Stories){
    Column(modifier = modifier.padding(5.dp)) {
        Image(painter = painterResource(id = stories.profile), contentDescription = "story_profile",
        modifier = Modifier
            .size(60.dp)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    listOf(
                        Color("#DE0046".toColorInt()),
                        Color("#F7A348".toColorInt())
                    ),
                ),
                shape = CircleShape,
            )
            .padding(5.dp)
            .clip(CircleShape),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = stories.userName, textAlign = TextAlign.Center,
            modifier = Modifier.width(60.dp), fontSize = 12.sp,
            color = Color.Black, fontWeight = FontWeight(500),
            overflow = TextOverflow.Ellipsis, maxLines = 1,
        )
    }
}

@Composable
fun PostsSection(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){

    }
}