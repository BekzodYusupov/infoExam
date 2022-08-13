package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface AddViewModel {
    val btnCancelLiveData: LiveData<Unit>
    val btnAddLivedata:LiveData<Unit>

    fun insert(noteEntity: NoteEntity)
    fun triggerBtnCancel()
    fun triggerBtnAdd()
}