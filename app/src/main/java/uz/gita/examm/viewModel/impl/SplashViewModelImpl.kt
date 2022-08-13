package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.examm.viewModel.SplashViewModel

class SplashViewModelImpl : SplashViewModel, ViewModel() {
    override val openCourseScreen: MutableLiveData<Unit> = MutableLiveData()

    init {
        viewModelScope.launch {
            delay(1500)
            openCourseScreen.value = Unit
        }
    }
}