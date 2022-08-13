package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.repository.impl.RepositoryImpl
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.EditScreenViewModel

class EditScreenViewModelImpl : EditScreenViewModel, ViewModel() {
    private val repo:Repository = RepositoryImpl()

    override val btnCancelLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val btnAddCancelLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun triggerCancelBtn() {
        btnCancelLiveData.value = Unit
    }

    override fun triggerAddBtn() {
        btnAddCancelLiveData.value = Unit
    }

    override fun getItem(id:Int):NoteEntity = repo.getItem(id)

    override fun update(noteEntity:NoteEntity) {
        repo.update(noteEntity)
    }
}