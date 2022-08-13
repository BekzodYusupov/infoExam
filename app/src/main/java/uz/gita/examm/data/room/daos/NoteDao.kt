package uz.gita.examm.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.gita.examm.data.room.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<NoteEntity>>

    @Insert
    fun insert(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Query("SELECT * FROM note WHERE id = :id")
    fun getItem(id: Int): NoteEntity

    @Query("SELECT * FROM note WHERE id = :id")
    fun getItemLive(id: Int): LiveData<NoteEntity>

    @Query("SELECT * FROM note WHERE title LIKE  '%'|| :search || '%' AND state=1")
    fun search(search: String?): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM note WHERE state=1")
    fun getAllowedUserNotes():LiveData<List<NoteEntity>>
}