package uz.gita.examm.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.repository.impl.RepositoryImpl
import uz.gita.examm.data.room.entities.NoteEntity
import uz.gita.examm.viewModel.ContentViewModel

class ContentViewModelImpl : ContentViewModel, ViewModel() {
    private val repo:Repository = RepositoryImpl()

    override val itemLivedata: MediatorLiveData<NoteEntity> = MediatorLiveData()
    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun triggerBack() {
        backLiveData.value = Unit
    }

    override fun getItemLive(id: Int){
        itemLivedata.addSource(repo.getItemLive(id)){
            itemLivedata.value = it
        }
    }
}