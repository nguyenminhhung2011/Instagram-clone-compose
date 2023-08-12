import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.abdroidbase.R
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.pager.rememberPagerState
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.launch

enum class  SunFlowerPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
){
    MY_GARDEN(R.string.my_garden, R.drawable.instagram),
    PLANT_LIST(R.string.plant_list, R.drawable.profile)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeSunFlower(
    modifier: Modifier = Modifier,// add constant
    onPlantClick: (Plant) -> Unit = {},
    onPageChange: (SunFlowerPage) -> Unit = {},
    onAttached: (Toolbar) -> Unit = {},
//    plantViewModel: PlantViewModel = hiltViewModel(),
){
//    val activity = (LocalContext.current as AppCompatActivity)
    val pagerState = rememberPagerState()
    HomePagerScreen(pagerState = pagerState)
//    AndroidViewBinding(factory = a)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePagerScreen(
    modifier: Modifier = Modifier,
    onPlantClick: (Plant) -> Unit = {},
    onPageChange: (SunFlowerPage) -> Unit = {},
    pagerState: PagerState,
    pages: Array<SunFlowerPage> = SunFlowerPage.values()
    ){
    LaunchedEffect(pagerState.currentPage){
        onPageChange(pages[pagerState.currentPage])
    }
    Column(modifier.nestedScroll(rememberNestedScrollInteropConnection())) {
        val coroutine =  rememberCoroutineScope()
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pages.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)

                Tab(selected = pagerState.currentPage == index,
                    onClick = { coroutine.launch { pagerState.animateScrollToPage(index) }},
                    text = { Text(text = title, style = TextStyle(color = Color.Black)) } ,
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title
                        )
                    },
                    unselectedContentColor = Color.Transparent,
                    selectedContentColor = Color.Red,
                )
            }
        }
        //pages
        HorizontalPager(pageCount = pages.size,
            modifier = Modifier.background(MaterialTheme.colors.background),
            state = pagerState,
            ) {index ->
            when(pages[index]){
                SunFlowerPage.MY_GARDEN -> {
                    GardenScreen()
                }
                SunFlowerPage.PLANT_LIST -> {
                    PlantScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun HomePreview(){
    HomePagerScreen(pagerState = rememberPagerState())
}


@Composable
fun PlantScreen(){
    Box(modifier = Modifier.fillMaxSize())
}
