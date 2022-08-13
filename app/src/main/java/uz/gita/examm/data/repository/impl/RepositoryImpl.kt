package uz.gita.examm.data.repository.impl

import androidx.lifecycle.LiveData
import uz.gita.examm.data.repository.Repository
import uz.gita.examm.data.room.AppDatabase
import uz.gita.examm.data.room.entities.NoteEntity

class RepositoryImpl : Repository {
    private val noteDao = AppDatabase.getInstance().noteDao()


    override fun getNotes(): LiveData<List<NoteEntity>> = noteDao.getNotes()


    override fun insert(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }

    override fun delete(noteEntity: NoteEntity) {
        noteDao.delete(noteEntity)
    }

    override fun update(noteEntity: NoteEntity) {
        noteDao.update(noteEntity)
    }

    override fun getItem(id: Int): NoteEntity = noteDao.getItem(id)
}