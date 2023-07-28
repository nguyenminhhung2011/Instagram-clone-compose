import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.core.graphics.*
import com.example.abdroidbase.R
import com.example.abdroidbase.model.Stories

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar()
        StoriesSection(listStories = getStories())
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .height(1.5.dp)
        )
        PostsSection()
    }
}

private fun getStories() = List(6) { Stories(userName = "Hung", profile = R.drawable.profile) }

@Composable
fun AppBar() {
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "logo",
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .align(Alignment.TopStart)
        )
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "create_post",
                    modifier = Modifier.size(20.dp)
                )
            }
            IconButton(onClick = { println("favorite") }) {
                Image(
                    painter = painterResource(id = R.drawable.love),
                    contentDescription = "create_post",
                    modifier = Modifier.size(22.dp)
                )
            }
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = "create_post",
                    modifier = Modifier.size(23.dp)
                )
            }
        }
    }
}

@Composable
fun StoriesSection(listStories: List<Stories>) {
    LazyRow(modifier = Modifier.padding(start = 10.dp)) {
        items(items = listStories) { story ->
            StoryItem(stories = story)
        }
    }
}

@Composable
fun StoryItem(stories: Stories) {
    Column(modifier = Modifier.padding(5.dp)) {
        Image(
            painter = painterResource(id = stories.profile),
            contentDescription = "story_profile",
            modifier = Modifier
                .size(60.dp)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color("#DE0046".toColorInt()),
                            Color("#F7A348".toColorInt())
                        )
                    ),
                    shape = CircleShape
                )
                .padding(5.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stories.userName,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(60.dp),
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight(500),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun PostsSection() {
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp)) {

    }
}