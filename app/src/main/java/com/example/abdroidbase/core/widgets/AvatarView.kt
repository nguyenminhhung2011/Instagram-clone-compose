package com.example.abdroidbase.core.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.example.abdroidbase.ui.theme.primaryColor

@Composable
fun AvatarView(image: String,
               onPress: ()-> Unit,
               size: Dp = 60.dp,
               isNetworkImage: Boolean = true
){
    IconButton(onClick = onPress) {
        AsyncImage(
            model = image,
            contentDescription = "avatar",
            modifier = Modifier
                .size(size)
                .border(
                    width = 2.5.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            primaryColor,
                            Color("#F7A348".toColorInt())
                        ),
                    ),
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit,
//            onLoading = (State.load)
        )
    }
}
