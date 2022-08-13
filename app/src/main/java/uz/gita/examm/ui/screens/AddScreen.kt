package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.ui.adapters.PagerAddAdapter
import uz.gita.examm.viewModel.AddViewModel
import uz.gita.examm.viewModel.impl.AddViewModelImpl

class AddScreen : Fragment(R.layout.screen_add) {
    private val viewModel: AddViewModel by viewModels<AddViewModelImpl>()
    private val navController: NavController by lazy { findNavController() }
    private val adapter: PagerAddAdapter by lazy { PagerAddAdapter() }
    private lateinit var btnAdd: Button
    private lateinit var btnCancel: Button
    private lateinit var pager: ViewPager2
    private lateinit var title: TextView
    private lateinit var content: TextView
    private var imageList: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.btnAddLivedata.observe(this) {
            navController.popBackStack()
        }

        viewModel.btnCancelLiveData.observe(this) {
            navController.popBackStack()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        loadImage()
        val dots = view.findViewById<DotsIndicator>(R.id.dots_indicatorAdd)
        btnCancel.setOnClickListener {
            viewModel.triggerBtnCancel()
        }
        btnAdd.setOnClickListener {
            val titleInput = title.text.toString()
            val contentInput = content.text.toString()
            if (titleInput.isNotEmpty() && contentInput.isNotEmpty()) {
                val note = NoteEntity(0, titleInput, contentInput, R.drawable.splash, true)

                viewModel.insert(note)
                viewModel.triggerBtnAdd()
            } else {
                Toast.makeText(requireContext(), "Pls fill all fields", Toast.LENGTH_SHORT).show()
            }

        }
        pager.adapter = adapter
        adapter.submitList(imageList)

        dots.attachTo(pager)
    }

    private fun init(view: View) {
        view.apply {
            btnAdd = findViewById(R.id.btnAddNote)
            btnCancel = findViewById(R.id.btnCancelNote)
            pager = findViewById(R.id.pagerAdd)
            title = findViewById(R.id.etAddTitle)
            content = findViewById(R.id.etAddContent)
        }
    }

    private fun loadImage() {
        imageList.add(R.drawable.splash)
        imageList.add(R.drawable.intro1)
        imageList.add(R.drawable.intro2)
        imageList.add(R.drawable.intro3)
        imageList.add(R.drawable.intro4)
        imageList.add(R.drawable.img)
        imageList.add(R.drawable.img1)
        imageList.add(R.drawable.im2)
        imageList.add(R.drawable.img3)
        imageList.add(R.drawable.img4)
        imageList.add(R.drawable.img5)
        imageList.add(R.drawable.img6)
        imageList.add(R.drawable.img7)
        imageList.add(R.drawable.img8)
        imageList.add(R.drawable.img9)
        imageList.add(R.drawable.img10)
    }


}