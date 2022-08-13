package uz.gita.examm.data.repository

import androidx.lifecycle.LiveData
import uz.gita.examm.data.room.entities.NoteEntity

interface Repository {

    fun getNotes(): LiveData<List<NoteEntity>>
    fun insert(noteEntity: NoteEntity)
    fun delete(noteEntity: NoteEntity)
    fun update(noteEntity: NoteEntity)
    fun getItemLive(id: Int): LiveData<NoteEntity>
    fun getItem(id: Int): NoteEntity
    fun search(search:String?):LiveData<List<NoteEntity>>
    fun getAllowedUserNotes():LiveData<List<NoteEntity>>
}