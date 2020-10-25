package com.example.android.devbyteviewer.note.notejop

import android.app.Application
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.devbyteviewer.databinding.FragmentNoteBinding
import com.example.android.devbyteviewer.note.notedatabase.DatabaseDAO
import com.example.android.devbyteviewer.note.notedatabase.Note
import kotlinx.coroutines.*
import java.lang.StringBuilder

class NoteViewModel(
    private val database: DatabaseDAO,
    private val binding: FragmentNoteBinding,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val notes = database.get()
    val noteString = Transformations.map(notes) { notes ->
        formatNote(notes)
    }

    private fun formatNote(note: List<Note>): Spanned {
        val sb = StringBuilder()
        sb.apply {
            //append(resources.getString(R.string.title))
            note.forEach {
                append(it.id)
                append(" : ")
                append(it.name)
                append("<br>")
            }
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onNoteAdd() {
        uiScope.launch {
            val newNote = Note()
            newNote.name = binding.editTextTextPersonName.text.toString()
            insert(newNote)
        }
    }

    private suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            database.insert(note)
        }
    }

}