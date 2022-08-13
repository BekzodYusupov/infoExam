package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.repository.impl.RepositoryImpl
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.AddViewModel

class AddViewModelImpl : AddViewModel, ViewModel() {
    private val repo:Repository = RepositoryImpl()

    override val btnCancelLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val btnAddLivedata: MutableLiveData<Unit> = MutableLiveData()

    override fun insert(noteEntity: NoteEntity) {
        repo.insert(noteEntity)
    }

    override fun triggerBtnCancel() {
        btnCancelLiveData.value = Unit
    }

    override fun triggerBtnAdd() {
        btnAddLivedata.value = Unit
    }
}