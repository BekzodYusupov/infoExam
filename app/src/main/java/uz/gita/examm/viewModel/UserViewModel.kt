package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface UserViewModel {
    val itemLiveData:LiveData<Int>
    val notesLiveData: LiveData<List<NoteEntity>>
    val searchLivedata:LiveData<List<NoteEntity>>

    fun getSearchedLiveData(search: String?)
    fun triggerItem(id:Int)
}