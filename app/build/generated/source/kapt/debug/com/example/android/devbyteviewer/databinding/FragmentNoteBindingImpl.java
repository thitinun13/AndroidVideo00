package com.example.android.devbyteviewer.databinding;
import com.example.android.devbyteviewer.R;
import com.example.android.devbyteviewer.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNoteBindingImpl extends FragmentNoteBinding implements com.example.android.devbyteviewer.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editTextTextPersonName, 3);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentNoteBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentNoteBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.buttonInsert.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textview.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.android.devbyteviewer.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.noteViewModel == variableId) {
            setNoteViewModel((com.example.android.devbyteviewer.note.notejop.NoteViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNoteViewModel(@Nullable com.example.android.devbyteviewer.note.notejop.NoteViewModel NoteViewModel) {
        this.mNoteViewModel = NoteViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.noteViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNoteViewModelNoteString((androidx.lifecycle.LiveData<android.text.Spanned>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNoteViewModelNoteString(androidx.lifecycle.LiveData<android.text.Spanned> NoteViewModelNoteString, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.LiveData<android.text.Spanned> noteViewModelNoteString = null;
        com.example.android.devbyteviewer.note.notejop.NoteViewModel noteViewModel = mNoteViewModel;
        android.text.Spanned noteViewModelNoteStringGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (noteViewModel != null) {
                    // read noteViewModel.noteString
                    noteViewModelNoteString = noteViewModel.getNoteString();
                }
                updateLiveDataRegistration(0, noteViewModelNoteString);


                if (noteViewModelNoteString != null) {
                    // read noteViewModel.noteString.getValue()
                    noteViewModelNoteStringGetValue = noteViewModelNoteString.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.buttonInsert.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textview, noteViewModelNoteStringGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // noteViewModel != null
        boolean noteViewModelJavaLangObjectNull = false;
        // noteViewModel
        com.example.android.devbyteviewer.note.notejop.NoteViewModel noteViewModel = mNoteViewModel;



        noteViewModelJavaLangObjectNull = (noteViewModel) != (null);
        if (noteViewModelJavaLangObjectNull) {


            noteViewModel.onNoteAdd();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): noteViewModel.noteString
        flag 1 (0x2L): noteViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}