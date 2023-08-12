//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.TextButton
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.FilterList
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import com.jetpack.compose.extension.toColor
//
//@Composable
//fun HeaderSearch(
//    colors: List<String> = listOf("992195F3", "CA2195F3"),
//    hintText: String = "Search",
//    hintStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle(color = MaterialTheme.colors.surface),
//    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.h6,
//    vPadding: Int = 10.dp.value,
//    hPadding: Int = 20.dp.value,
//    searchRadius: Int = 14.dp.value,
//    prefixIcon: @Composable (() -> Unit)? = { Icon(Icons.Filled.Search, null) },
//    textChange: (String) -> Unit = {},
//    isShowAction: Boolean = true,
//    actionIcon: @Composable (() -> Unit)? = { Icon(Icons.Filled.FilterList, null) },
//    onPress: () -> Unit = {},
//    filterCall: (Any) -> Unit = {}
//) {
//    val textColor = MaterialTheme.colors.surface
//    val prefixIconColor = MaterialTheme.colors.onSurface
//    val textValueState = androidx.compose.runtime.mutableStateOf(TextFieldValue(""))
//
//    Column {
//        Box(
//            Modifier
//                .fillMaxWidth()
//                .padding(vertical = vPadding.dp)
//                .padding(horizontal = hPadding.dp)
//                .background(
//                    brush = androidx.compose.foundation.background.GradientDrawable(
//                        colors.map { it.toColor() },
//                        0f,
//                        0f,
//                        0f,
//                        1f,
//                        androidx.compose.ui.unit.Dp.Infinity,
//                        androidx.compose.ui.unit.Dp.Infinity
//                    )
//                ),
//            contentAlignment = androidx.compose.ui.Alignment.CenterStart
//        ) {
//            OutlinedTextField(
//                value = textValueState.value,
//                onValueChange = {
//                    textValueState.value = it
//                    textChange.invoke(it.text)
//                },
//                textStyle = textStyle,
//                leadingIcon = prefixIcon?.invoke(),
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(searchRadius.dp),
//                placeholder = {
//                    androidx.compose.material.LocalContentColorSurface(
//                        contentColor = hintStyle.color
//                    ) {
//                        androidx.compose.material.Text(text = hintText, style = hintStyle)
//                    }
//                },
//                colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
//                    textColor = textColor,
//                    cursorColor = textColor,
//                    leadingIconColor = prefixIconColor,
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent,
//                    disabledBorderColor = Color.Transparent
//                )
//            )
//            if (isShowAction) {
//                TextButton(
//                    onClick = onPress,
//                    modifier = Modifier.align(androidx.compose.ui.Alignment.CenterEnd)
//                ) {
//                    actionIcon?.invoke()
//                }
//            }
//        }
//    }
//}