import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun <T> NavHostController.AppCoordinator() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    fun pop() {
        scope.launch {
            this@AppCoordinator.popBackStack()
        }
    }

    fun popUntil(nRoute: String) {
        scope.launch {
            this@AppCoordinator.popBackStack(nRoute, false)
        }
    }

    fun popArgs(args: T?) {
        scope.launch {
            this@AppCoordinator.previousBackStackEntry?.savedStateHandle?.set("args", args)
            this@AppCoordinator.popBackStack()
        }
    }


    fun openListPageWithRoute(route: String) {
        scope.launch {
            this@AppCoordinator.navigate(route)
        }
    }

//    fun pushAndRemoveAll(route: String) {
//        scope.launch {
//            this@appCoordinator.navigate(route) {
//                popUpTo(this@pushAndRemoveAll.graph.startDestinationId) {
//                    inclusive = true
//                }
//            }
//        }
//    }
//
//    fun openPageWithRouteAndParams(route: String, param: Any?) {
//        scope.launch {
//            this@appCoordinator.navigate(route, param)
//        }
//    }

}