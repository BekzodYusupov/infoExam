package uz.gita.examm.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val content:String,
    val img:Int,
    val state: Boolean
)
