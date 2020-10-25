package com.example.android.devbyteviewer.note.notejop

import android.os.Bundle
import android.view.*
import androidx.core.text.set
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.devbyteviewer.R
import com.example.android.devbyteviewer.databinding.FragmentNoteBinding
import com.example.android.devbyteviewer.note.notedatabase.DatabaseNote


class NoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<FragmentNoteBinding>(
            inflater,
            R.layout.fragment_note,
            container,
            false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application
        val dataSource = DatabaseNote.getInstance(application).databaseDao
        val viewModelFactory = NoteViewModelFactory(dataSource, binding, application)
        val noteViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(NoteViewModel::class.java)
        binding.noteViewModel = noteViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}