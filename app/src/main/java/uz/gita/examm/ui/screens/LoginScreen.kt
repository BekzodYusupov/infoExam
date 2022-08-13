package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.gita.examm.R
import uz.gita.examm.viewModel.LoginViewModel
import uz.gita.examm.viewModel.impl.LoginViewModelImpl

class LoginScreen : Fragment(R.layout.screen_login) {
    private lateinit var inputLogin: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnConfirm: Button
    private val navController:NavController by lazy { findNavController() }

    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openUserScreenLivedata.observe(this){
            navController.navigate(R.id.action_loginScreen_to_userScreen)
        }

        viewModel.openAdminScreenLivedata.observe(this){
            navController.navigate(R.id.action_loginScreen_to_adminScreen)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)

        btnConfirm.setOnClickListener {
            val login: String = inputLogin.text.toString()
            val password: String = inputPassword.text.toString()

            viewModel.getLogin(login)
            viewModel.getPassword(password)
            viewModel.check(login, password)
        }
    }

    private fun init(view: View) {
        view.apply {
            inputLogin = findViewById(R.id.etLogin)
            inputPassword = findViewById(R.id.etPassword)
            btnConfirm = findViewById(R.id.btnLogin)
        }
    }
}