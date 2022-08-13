package uz.gita.examm.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.examm.data.room.daos.NoteDao
import uz.gita.examm.data.room.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var instance:AppDatabase? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"note_db.db")
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getInstance():AppDatabase = instance!!
    }
}