package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import uz.gita.examm.R
import uz.gita.examm.data.models.IntroModel
import uz.gita.examm.ui.adapters.IntroAdapter
import uz.gita.examm.viewModel.impl.IntroViewModelImpl

class IntroScreen : Fragment(R.layout.screen_intro) {
    private val viewModel: IntroViewModelImpl by viewModels()
    private val dataList: ArrayList<IntroModel> = ArrayList()
    lateinit var pager: ViewPager2
    private val adapter: IntroAdapter by lazy { IntroAdapter() }
    private lateinit var btnPrevious: TextView
    private lateinit var btnNext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openLoginScreen.observe(this) {
            findNavController().navigate(R.id.action_introScreen_to_loginScreen)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pager = view.findViewById(R.id.pager)
        btnPrevious = view.findViewById(R.id.btnPreviuos)
        btnNext = view.findViewById(R.id.btnNext)
        val dots = view.findViewById<DotsIndicator>(R.id.dots_indicator)

        loadData()
        adapter.submitList(dataList)
        pager.adapter = adapter

        btnPrevious.setOnClickListener {
            if (pager.currentItem > 0) pager.currentItem--
        }

        btnNext.setOnClickListener {
            if (pager.currentItem < 3) {
                pager.currentItem++
            } else {
                viewModel.triggerLoginScreen()
            }
        }

        dots.attachTo(pager)
    }

    private fun loadData() {
        dataList.add(
            IntroModel(
                R.drawable.intro1,
                "Welcome",
                "Info is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s, when an unknown printer took a galle",
                R.color.intro1
            )
        )
        dataList.add(
            IntroModel(
                R.drawable.intro2,
                "Hello",
                "Info is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s, when an unknown printer took a galle",
                R.color.intro2
            )
        )
        dataList.add(
            IntroModel(
                R.drawable.intro3,
                "Amazing",
                "Info is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s, when an unknown printer took a galle",
                R.color.intro3
            )
        )
        dataList.add(
            IntroModel(
                R.drawable.intro4,
                "Cheers",
                "Info is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry standard dummy text ever since the 1500s, when an unknown printer took a galle",
                R.color.intro4
            )
        )

    }

}