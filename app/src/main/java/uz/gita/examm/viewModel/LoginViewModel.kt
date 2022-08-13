package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData

interface LoginViewModel {

    val openAdminScreenLivedata:LiveData<Unit>
    val openUserScreenLivedata: LiveData<Unit>
    val loginInputLivedata: LiveData<String>
    val passwordInputLivedata:LiveData<String>

    fun triggerAdminScreen()
    fun triggerUserScreen()
    fun check(login: String, password: String)

    fun getLogin(login: String)
    fun getPassword(password: String)

}