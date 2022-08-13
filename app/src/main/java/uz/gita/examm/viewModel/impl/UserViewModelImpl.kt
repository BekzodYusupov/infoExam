package uz.gita.examm.viewModel.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.repository.impl.RepositoryImpl
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.UserViewModel

class UserViewModelImpl : UserViewModel, ViewModel() {
    override val itemLiveData: MutableLiveData<Int> = MutableLiveData()
    private val repo:Repository = RepositoryImpl()
    override val notesLiveData: MediatorLiveData<List<NoteEntity>> = MediatorLiveData()
    override val searchLivedata: MutableLiveData<List<NoteEntity>> = MutableLiveData()

    init {
        notesLiveData.addSource(repo.getAllowedUserNotes()){
            notesLiveData.value = it
        }
    }

    override fun getSearchedLiveData(search: String?) {
        notesLiveData.addSource(repo.search(search)){
            searchLivedata.value = it
        }
    }

    override fun triggerItem(id: Int) {
        itemLiveData.value = id
    }
}