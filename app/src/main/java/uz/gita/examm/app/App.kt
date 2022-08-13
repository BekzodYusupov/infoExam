package uz.gita.examm.app

import android.app.Application
import uz.gita.examm.data.room.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}