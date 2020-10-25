package com.example.android.devbyteviewer.note.notejop;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0019H\u0014J\u0006\u0010\u001c\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/android/devbyteviewer/note/notejop/NoteViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "database", "Lcom/example/android/devbyteviewer/note/notedatabase/DatabaseDAO;", "binding", "Lcom/example/android/devbyteviewer/databinding/FragmentNoteBinding;", "application", "Landroid/app/Application;", "(Lcom/example/android/devbyteviewer/note/notedatabase/DatabaseDAO;Lcom/example/android/devbyteviewer/databinding/FragmentNoteBinding;Landroid/app/Application;)V", "noteString", "Landroidx/lifecycle/LiveData;", "Landroid/text/Spanned;", "kotlin.jvm.PlatformType", "getNoteString", "()Landroidx/lifecycle/LiveData;", "notes", "", "Lcom/example/android/devbyteviewer/note/notedatabase/Note;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "viewModelJob", "Lkotlinx/coroutines/CompletableJob;", "formatNote", "note", "insert", "", "(Lcom/example/android/devbyteviewer/note/notedatabase/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "onNoteAdd", "app_debug"})
public final class NoteViewModel extends androidx.lifecycle.AndroidViewModel {
    private kotlinx.coroutines.CompletableJob viewModelJob;
    private final kotlinx.coroutines.CoroutineScope uiScope = null;
    private final androidx.lifecycle.LiveData<java.util.List<com.example.android.devbyteviewer.note.notedatabase.Note>> notes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<android.text.Spanned> noteString = null;
    private final com.example.android.devbyteviewer.note.notedatabase.DatabaseDAO database = null;
    private final com.example.android.devbyteviewer.databinding.FragmentNoteBinding binding = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<android.text.Spanned> getNoteString() {
        return null;
    }
    
    private final android.text.Spanned formatNote(java.util.List<com.example.android.devbyteviewer.note.notedatabase.Note> note) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void onNoteAdd() {
    }
    
    public NoteViewModel(@org.jetbrains.annotations.NotNull()
    com.example.android.devbyteviewer.note.notedatabase.DatabaseDAO database, @org.jetbrains.annotations.NotNull()
    com.example.android.devbyteviewer.databinding.FragmentNoteBinding binding, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}