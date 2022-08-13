package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.ContentViewModel
import uz.gita.examm.viewModel.impl.ContentViewModelImpl

class ContentScreen : Fragment(R.layout.screen_content) {
    private val viewModel: ContentViewModel by viewModels<ContentViewModelImpl>()
    private val navController: NavController by lazy { findNavController() }
    private lateinit var ivBack: ImageView
    private lateinit var title: TextView
    private lateinit var content: TextView
    private var noteId = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backLiveData.observe(this) {
            navController.popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        ivBack.setOnClickListener {
            viewModel.triggerBack()
        }
        noteId = arguments?.getInt("IDCONTENT")!!

        viewModel.getItemLive(noteId)
        viewModel.itemLivedata.observe(viewLifecycleOwner){
            title.text = it.title
            content.text = it.content
        }

    }

    private fun init(view: View) {
        view.apply {
            ivBack = findViewById(R.id.ivbackUser)
            title = findViewById(R.id.tvContentTitle)
            content = findViewById(R.id.tvContentContent)
        }
    }
}