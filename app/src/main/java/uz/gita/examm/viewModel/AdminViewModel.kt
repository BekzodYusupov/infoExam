package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface AdminViewModel {
    val openAddScreen:LiveData<Unit>
    val notesLivedata:MediatorLiveData<List<NoteEntity>>
    val itemLivedata:LiveData<Int>

    fun delete(noteEntity: NoteEntity)
    fun insert(noteEntity: NoteEntity)
    fun update(noteEntity: NoteEntity)
    fun trigger()
    fun setPlaceHolder():Boolean
    fun triggerItemClick(id:Int)
}