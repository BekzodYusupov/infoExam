package uz.gita.examm.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.gita.examm.R
import uz.gita.examm.viewModel.impl.SplashViewModelImpl

class SplashScreen : Fragment(R.layout.splash_screen) {
    private val viewModel: SplashViewModelImpl by viewModels()

    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCourseScreen.observe(this){
            navController.navigate(R.id.action_splashScreen2_to_introScreen)
        }
    }
}