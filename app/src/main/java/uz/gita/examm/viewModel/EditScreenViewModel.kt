package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface EditScreenViewModel {
    val btnCancelLiveData: LiveData<Unit>
    val btnAddCancelLiveData: LiveData<Unit>

    fun triggerCancelBtn()
    fun triggerAddBtn()
    fun getItem(id: Int): NoteEntity
    fun update(noteEntity: NoteEntity)
}