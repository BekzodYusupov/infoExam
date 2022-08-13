package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.EditScreenViewModel
import uz.gita.examm.viewModel.impl.EditScreenViewModelImpl

class EditScreen:Fragment(R.layout.screen_edit) {
    private lateinit var etTitle:EditText
    private lateinit var etContent:EditText
    private lateinit var btnEdit:Button
    private lateinit var btnCancel:Button
    private val viewModel:EditScreenViewModel by viewModels<EditScreenViewModelImpl>()
    private val navController: NavController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.btnCancelLiveData.observe(this){
            navController.popBackStack()
        }

        viewModel.btnAddCancelLiveData.observe(this){
            navController.popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)

        val id = arguments?.getInt("ID")!!
        val note = viewModel.getItem(id)
        etTitle.setText(note.title)
        etContent.setText(note.content)

        btnCancel.setOnClickListener {
            viewModel.triggerCancelBtn()
        }

        btnEdit.setOnClickListener {
            val title:String = etTitle.text.toString()
            val content:String = etContent.text.toString()
            val newNote = NoteEntity(id,title,content,R.drawable.splash,note.state)
            viewModel.update(newNote)
            viewModel.triggerAddBtn()
        }
    }

    private fun init(view: View) {
        view.apply {
            etTitle = findViewById(R.id.etEditTitle)
            etContent = findViewById(R.id.etEditContent)
            btnEdit = findViewById(R.id.btnAddEdit)
            btnCancel = findViewById(R.id.btnCancelEdit)
        }
    }
}