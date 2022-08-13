package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.repository.impl.RepositoryImpl
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.AdminViewModel

class AdminViewModelImpl : AdminViewModel,ViewModel() {
    private val repo:Repository = RepositoryImpl()
    override val itemLivedata: MutableLiveData<Int> = MutableLiveData()
    override val openAddScreen: MutableLiveData<Unit> = MutableLiveData()
    override val notesLivedata: MediatorLiveData<List<NoteEntity>> = MediatorLiveData()

    init {
        notesLivedata.addSource(repo.getNotes()){
            notesLivedata.value = it
        }
    }

    override fun delete(noteEntity: NoteEntity) {
        repo.delete(noteEntity)
    }

    override fun insert(noteEntity: NoteEntity) {
        repo.insert(noteEntity)
    }

    override fun update(noteEntity: NoteEntity) {
        repo.update(noteEntity)
    }

    override fun trigger() {
        openAddScreen.value = Unit
    }

    override fun triggerItemClick(id: Int) {
        itemLivedata.value = id
    }
}