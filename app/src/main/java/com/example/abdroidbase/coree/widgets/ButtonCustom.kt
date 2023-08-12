import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCustom(
    color: Color? = null,
    radius: Double? = null,
    width: Double? = null,
    height: Double? = null,
    enableWidth: Boolean = true,
    loading: Boolean = false,
    borderColor: Color? = null,
    child: @Composable () -> Unit,
    onPress: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(height?.dp ?: 0.dp)
    ) {
        Button(
            onClick = { if (!loading) onPress() },
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(radius?.dp ?: 10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = color ?: MaterialTheme.colors.primary,
                contentColor = contentColorFor(color ?: MaterialTheme.colors.primary)
            ),
            border = BorderStroke(
                1.dp,
                borderColor ?: color ?: MaterialTheme.colors.primary
            )
        ) {
            if (loading) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp
                )
            } else {
                child()
            }
        }
    }
}