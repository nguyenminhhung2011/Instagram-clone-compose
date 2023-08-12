package com.example.abdroidbase.core.widgets
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abdroidbase.data.model.Post
import com.example.abdroidbase.data.model.User
import com.example.abdroidbase.R


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun PostItem(post: Post, user: User){
    val headerStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        color = Color.Black
    )
    Box(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            ) {
            val pageState = rememberPagerState()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AvatarView(image = user.photoUrl, onPress = {}, size = 40.dp)
                SizedBox(width = 5.dp)
                Column(modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start) {
                    Text(text = user.userName,
                        overflow = TextOverflow.Ellipsis,
                        style = headerStyle
                    )
                    Text(text = user.bio, fontWeight = FontWeight   (500),
                        fontSize = 10.sp, overflow = TextOverflow.Ellipsis,
                        color = Color.Gray
                    )
                }
                IconButton(onClick = {}) {
                    Image(painter = painterResource(id = R.drawable.more_vertical) ,
                        contentDescription =null,
                        modifier = Modifier.size(16.dp)
                    )
                }

            }
            SizedBox(height = 10.dp)
            Box(modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(400.dp)){
                HorizontalPager(pageCount = post.postUrls.size, state = pageState) { index ->
                    AsyncImage(model = post.postUrls[index],
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .height(300.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            SizedBox(height = 5.dp)
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 5.dp)) {
                    listOf<Map<String,Any>>(
                        mapOf("icon" to R.drawable.love, "size" to 20.dp),
                        mapOf("icon" to R.drawable.comment, "size" to 18.dp),
                    ).forEachIndexed { index, item ->
                        IconButton(onClick = {
                            if(index ==0 ){
                                println(0)
                            }
                        }, modifier = Modifier.padding(0.dp)) {
                            Image(painter = painterResource(id = item["icon"] as Int),
                                contentDescription =null,
                                modifier = Modifier
                                    .width(item["size"] as Dp)
                                    .height(item["size"] as Dp),
                                contentScale = ContentScale.FillBounds
                            )
                            
                        }
                        SizedBox(width = 10.dp)
                    }
                }
            }
            LazyRow(horizontalArrangement = Arrangement.spacedBy((-10).dp),
                modifier = Modifier.padding(horizontal = 18.dp)){
                item{
                    // dump data but code is true
                    listOf(R.drawable.profile,
                        R.drawable.profile,
                        R.drawable.profile,
                        R.drawable.profile
                    ).forEach { item ->
                        Image(painter = painterResource(id = item), contentDescription =null,
                            modifier = Modifier
                                .size(24.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color.White,
                                    shape = CircleShape
                                )
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            )
                    }
                    Text(text = " and ${post.favorites.size} likes",
                        style = headerStyle,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
            SizedBox(height = 5.dp)
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = headerStyle.fontSize,
                            fontWeight = headerStyle.fontWeight,
                            color = headerStyle.color,
                        )
                    ){
                        append(user.userName)
                    }
                    append(post.description)
                    },
                fontSize = 13.sp,
                fontWeight = FontWeight(600),
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 20.dp )
            )
            TextButton(onClick = {}, modifier = Modifier.padding(horizontal = 15.dp), ) {
                Text(text = "View all comments", style = headerStyle.copy(
                    color = Color.Gray,
                ))
            }
            SizedBox(height = 20.dp)
        }

    }

}

@Preview
@Composable
fun Preview(){
    LazyRow(horizontalArrangement = Arrangement.spacedBy((-10).dp),
        modifier = Modifier.padding(horizontal = 18.dp)){
        item{
            // dump data but code is true
            listOf(R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile,
                R.drawable.profile
            ).forEach { item ->
                Image(painter = painterResource(id = item), contentDescription =null,
                    modifier = Modifier
                        .size(24.dp)
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

