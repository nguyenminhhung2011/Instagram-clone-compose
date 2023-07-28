//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//
//@Composable
//fun SwipedCustom(
//    itemCount: Int,
//    itemBuilder: @Composable (index: Int) -> Unit,
//    width: Double? = null,
//    height: Double? = null,
//    viewPortFraction: Double? = null,
//    scale: Double? = null,
//    duration: Int? = null,
//    autoPlay: Boolean? = null,
//    swipedLayout: SwiperLayout? = null,
//    margin: EdgeInsetsGeometry? = null,
//    isShowSlideDot: Boolean = true,
//    isCenterSlideDot: Boolean = true,
//    spacingItem: Double? = null,
//    swipperOnly: Boolean = false,
//    controller: SwiperController? = null,
//) {
//    val swiperController = remember { controller ?: SwiperController() }
//    val index = remember { mutableStateOf(0) }
//
//    DisposableEffect(key1 = swiperController) {
//        val listener = { index.value = swiperController.currentPage }
//        swiperController.registerOnPageChangeCallback(listener)
//        onDispose { swiperController.unregisterOnPageChangeCallback(listener) }
//    }
//
//    fun changeView(newIndex: Int) {
//        index.value = newIndex
//        swiperController.scrollTo(newIndex)
//    }
//
//    val swiper = {
//        Swiper(
//            modifier = Modifier.fillMaxSize(),
//            onIndexChanged = { changeView(it) },
//            layout = swipedLayout ?: SwiperLayout.Tinder,
//            controller = swiperController,
//            autoplay = autoPlay ?: false,
//            viewportFraction = viewPortFraction?.toFloat() ?: 0.8f,
//            scale = scale?.toFloat() ?: 0.9f,
//            duration = duration ?: 300,
//            count = itemCount,
//            itemSpacing = spacingItem?.dp ?: 0.dp,
//            itemBuilder = { _, index -> itemBuilder(index) }
//        )
//    }
//
//    if (swipperOnly) {
//        Box(modifier = Modifier
//            .width(width?.dp ?: 0.dp)
//            .height(height?.dp ?: 0.dp)) {
//            swiper()
//        }
//    } else {
//        Column(
//            modifier = Modifier.padding(margin ?: PaddingValues(0.dp)),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Box(
//                modifier = Modifier
//                    .width(width?.dp ?: 0.dp)
//                    .height(height?.dp ?: 0.dp)
//                    .weight(1f)
//            ) {
//                swiper()
//            }
//            if (isShowSlideDot) {
//                Row(
//                    horizontalArrangement = if (isCenterSlideDot) Arrangement.Center else Arrangement.Start
//                ) {
//                    for (i in 0 until itemCount) {
//                        BuildIndicator(
//                            isActive = i == index.value,
//                            onPress = { changeView(i) }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun BuildIndicator(
//    isActive: Boolean,
//    onPress: () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .padding(horizontal = 5.dp)
//            .clickable(onClick = onPress)
//    ) {
//        Box(
//            modifier = Modifier
//                .height(10.dp)
//                .width(if (isActive) 30.dp else 10.dp)
//                .background(
//                    color = if (isActive) MaterialTheme.colors.primary
//                    else MaterialTheme.colors.primary.copy(alpha = 0.2f),
//                    shape = MaterialTheme.shapes.small
//                )
//        )
//    }
//}