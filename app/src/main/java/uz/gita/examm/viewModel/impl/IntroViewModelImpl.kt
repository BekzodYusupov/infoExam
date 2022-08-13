package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.examm.viewModel.IntroViewModel

class IntroViewModelImpl : IntroViewModel, ViewModel() {
    override val openLoginScreen: MutableLiveData<Unit> = MutableLiveData()
    override val previousSplash = MutableLiveData<Unit>()
    override val nextSplash = MutableLiveData<Unit>()

    override fun triggerLoginScreen() {
        openLoginScreen.value = Unit
    }

    override fun triggerPrevious() {
        previousSplash.value = Unit
    }

    override fun triggerNext() {
        nextSplash.value = Unit
    }

}