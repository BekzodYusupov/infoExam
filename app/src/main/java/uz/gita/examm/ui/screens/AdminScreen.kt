package uz.gita.examm.ui.screens

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.examm.R
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.ui.adapters.AdminAdapter
import uz.gita.examm.viewModel.AdminViewModel
import uz.gita.examm.viewModel.impl.AdminViewModelImpl

class AdminScreen : Fragment(R.layout.screen_admin) {
    lateinit var placeHolder:ImageView
    lateinit var container: RecyclerView
    lateinit var fabAdd: FloatingActionButton
    private val adapter: AdminAdapter by lazy { AdminAdapter() }
    private val viewModel: AdminViewModel by viewModels<AdminViewModelImpl>()
    private val navController:NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openAddScreen.observe(this){
            navController.navigate(R.id.action_adminScreen_to_addScreen)
        }
        viewModel.itemLivedata.observe(this){
            val bundle = Bundle()
            bundle.putInt("ID",it)
            navController.navigate(R.id.action_adminScreen_to_editScreen, bundle)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)

        fabAdd.setOnClickListener {
            viewModel.trigger()
        }

        container.adapter = adapter
        viewModel.notesLivedata.observe(viewLifecycleOwner){
            if (it.isEmpty()) {
                placeHolder.visibility = View.VISIBLE
            } else {
                placeHolder.visibility = View.INVISIBLE
            }
            adapter.submitList(it)
        }



        adapter.triggerItemClickListener {
            viewModel.triggerItemClick(it)
        }

        adapter.triggerCheckClickListener { noteEntity, b ->
            val note = NoteEntity(noteEntity.id,noteEntity.title,noteEntity.content,noteEntity.img,b)
            viewModel.update(note)
        }

        adapter.triggerItemLongClickListener {
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Delete?")
            dialog.setPositiveButton("Yes"){d,i->
                viewModel.delete(it)
                d.dismiss()
            }
            dialog.setNegativeButton("No"){d,i->
                d.dismiss()
            }
            dialog.show()

        }
    }

    private fun init(view: View) {
        view.apply {
            container = findViewById(R.id.containerAdmin)
            fabAdd = findViewById(R.id.fabAdd)
            placeHolder = findViewById(R.id.placeHolder)
        }
    }
}