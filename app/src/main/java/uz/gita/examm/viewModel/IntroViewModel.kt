package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import java.nio.file.attribute.UserPrincipal

interface IntroViewModel {
    val openLoginScreen:LiveData<Unit>
    val previousSplash: LiveData<Unit>
    val nextSplash: LiveData<Unit>

    fun triggerLoginScreen()
    fun triggerPrevious()
    fun triggerNext()
}