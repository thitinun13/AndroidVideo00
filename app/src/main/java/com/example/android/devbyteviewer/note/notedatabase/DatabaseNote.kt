package com.example.android.devbyteviewer.note.notedatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class DatabaseNote : RoomDatabase(){
    abstract val databaseDao: DatabaseDAO

    companion object{
        @Volatile
        private var INSTANCE: DatabaseNote? = null
        fun getInstance(context: Context): DatabaseNote {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseNote::class.java,
                        "database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}