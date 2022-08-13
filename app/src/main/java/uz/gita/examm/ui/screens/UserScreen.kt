package uz.gita.examm.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import uz.gita.examm.R
import uz.gita.examm.ui.adapters.UserAdapter
import uz.gita.examm.viewModel.UserViewModel
import uz.gita.examm.viewModel.impl.UserViewModelImpl

class UserScreen:Fragment(R.layout.screen_user) {
    private val viewModel: UserViewModel by viewModels<UserViewModelImpl>()
    private val navController:NavController by lazy { findNavController() }
    private val adapter:UserAdapter by lazy { UserAdapter() }
    private lateinit var search:android.widget.SearchView
    private lateinit var container:RecyclerView
    private lateinit var placeHolder:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.itemLiveData.observe(this){
            val bundle = Bundle()
            bundle.putInt("IDCONTENT",it)
            navController.navigate(R.id.action_userScreen_to_contentScreen, bundle)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(view)
        viewModel.notesLiveData.observe(viewLifecycleOwner){
            if (it.isEmpty()) {
                placeHolder.visibility = View.VISIBLE
            } else {
                placeHolder.visibility = View.INVISIBLE
            }
            adapter.submitList(it)
        }

        adapter.triggerItemClickListener {
            viewModel.triggerItem(it)
        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getSearchedLiveData(newText)
                return true
            }

        })

        viewModel.searchLivedata.observe(viewLifecycleOwner){
            if (it.isEmpty()) {
                placeHolder.visibility = View.VISIBLE
            } else {
                placeHolder.visibility = View.INVISIBLE
            }
            adapter.submitList(it)
        }
    }

    private fun init(view: View) {
        view.apply {
            search = findViewById(R.id.search_bar)
            container = findViewById(R.id.containerUser)
            container.adapter = adapter
            placeHolder = findViewById(R.id.placeHolderUser)
        }
    }

}