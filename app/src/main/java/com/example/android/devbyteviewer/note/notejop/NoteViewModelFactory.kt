package com.example.android.devbyteviewer.note.notejop

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.devbyteviewer.databinding.FragmentNoteBinding
import com.example.android.devbyteviewer.note.notedatabase.DatabaseDAO


class NoteViewModelFactory (
    private val dataSource: DatabaseDAO,
    private val binding: FragmentNoteBinding,
    private val application: Application
) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(dataSource,binding, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}