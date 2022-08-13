package uz.gita.examm.viewModel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.viewModel.LoginViewModel
import kotlin.math.log

class LoginViewModelImpl : LoginViewModel, ViewModel() {

    override val openAdminScreenLivedata: MutableLiveData<Unit> = MutableLiveData()

    override val openUserScreenLivedata: MutableLiveData<Unit> = MutableLiveData()

    override val loginInputLivedata: MutableLiveData<String> = MutableLiveData()

    override val passwordInputLivedata: MutableLiveData<String> = MutableLiveData()


    override fun triggerAdminScreen() {
        openAdminScreenLivedata.value = Unit
    }

    override fun triggerUserScreen() {
        openUserScreenLivedata.value = Unit
    }

    override fun check(login: String, password: String) {
        if (loginInputLivedata.value == "admin" && passwordInputLivedata.value=="1234") {
            triggerAdminScreen()
        } else if (loginInputLivedata.value == "user" && passwordInputLivedata.value == "1234") {
            triggerUserScreen()
        }
    }

    override fun getLogin(login: String) {
        loginInputLivedata.value = login
    }

    override fun getPassword(password: String) {
        passwordInputLivedata.value = password
    }
}