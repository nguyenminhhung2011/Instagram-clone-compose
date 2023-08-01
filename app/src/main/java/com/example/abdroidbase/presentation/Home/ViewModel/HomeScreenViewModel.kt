import androidx.lifecycle.ViewModel

sealed class  HomeScreenState {
    object Loading : HomeScreenState()

}

class HomeScreenViewModel : ViewModel() {
}