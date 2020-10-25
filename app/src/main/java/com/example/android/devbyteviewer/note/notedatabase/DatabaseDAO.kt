package com.example.android.devbyteviewer.note.notedatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDAO {
    @Insert
    fun insert(note: Note)

    @Query("SELECT * from note_table")
    fun get(): LiveData<List<Note>>
}