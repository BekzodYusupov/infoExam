package uz.gita.examm.viewModel

import androidx.lifecycle.LiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface ContentViewModel {
    val backLiveData:LiveData<Unit>
    val itemLivedata:LiveData<NoteEntity>

    fun triggerBack()
    fun getItemLive(id:Int)
}