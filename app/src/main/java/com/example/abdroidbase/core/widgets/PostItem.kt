package com.example.abdroidbase.core.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.example.abdroidbase.data.model.Post
import com.example.abdroidbase.data.model.User

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostItem(post: Post, user: User){
    Box(modifier = Modifier.fillMaxWidth()){
        val pageState = rememberPagerState()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
            ) {
            AvatarView(image = user.photoUrl, onPress = {}, size = 30.dp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = user.userName, fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp, overflow = TextOverflow.Ellipsis)

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)){
            HorizontalPager(pageCount = post.postUrls.size, state = pageState) { index ->
                AsyncImage(model = post.postUrls[index],
                            contentDescription ="images",
                            modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}

@Composable
fun AvatarView(image: String,
               onPress: ()-> Unit,
               size: Dp = 60.dp,
               isNetworkImage: Boolean = true
){
    Button(onClick = onPress) {
        AsyncImage(
            model = image,
            contentDescription = "avatar",
            modifier = Modifier
                .size(size)
                .border(
                    width = 1.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color("#DE0046".toColorInt()),
                            Color("#F7A348".toColorInt())
                        ),
                    ),
                    shape = CircleShape
                )
                .padding(2.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
    }
}