package uz.gita.examm.ui.screens

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
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            Log.d("QQQQ","$it")
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
            adapter.submitList(it)
        }

        if (viewModel.setPlaceHolder()) {
            placeHolder.visibility = View.VISIBLE
        } else {
            placeHolder.visibility = View.INVISIBLE
        }

        adapter.triggerItemClickListener {
            Toast.makeText(requireContext(), "$it aaa", Toast.LENGTH_SHORT).show()
            viewModel.triggerItemClick(it)
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