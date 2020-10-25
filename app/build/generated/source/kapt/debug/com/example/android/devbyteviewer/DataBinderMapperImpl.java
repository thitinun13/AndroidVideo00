package com.example.android.devbyteviewer;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.android.devbyteviewer.databinding.ActivityDevByteViewerBindingImpl;
import com.example.android.devbyteviewer.databinding.DevbyteItemBindingImpl;
import com.example.android.devbyteviewer.databinding.FragmentDevByteBindingImpl;
import com.example.android.devbyteviewer.databinding.FragmentNoteBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYDEVBYTEVIEWER = 1;

  private static final int LAYOUT_DEVBYTEITEM = 2;

  private static final int LAYOUT_FRAGMENTDEVBYTE = 3;

  private static final int LAYOUT_FRAGMENTNOTE = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.devbyteviewer.R.layout.activity_dev_byte_viewer, LAYOUT_ACTIVITYDEVBYTEVIEWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.devbyteviewer.R.layout.devbyte_item, LAYOUT_DEVBYTEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.devbyteviewer.R.layout.fragment_dev_byte, LAYOUT_FRAGMENTDEVBYTE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.android.devbyteviewer.R.layout.fragment_note, LAYOUT_FRAGMENTNOTE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYDEVBYTEVIEWER: {
          if ("layout/activity_dev_byte_viewer_0".equals(tag)) {
            return new ActivityDevByteViewerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_dev_byte_viewer is invalid. Received: " + tag);
        }
        case  LAYOUT_DEVBYTEITEM: {
          if ("layout/devbyte_item_0".equals(tag)) {
            return new DevbyteItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for devbyte_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDEVBYTE: {
          if ("layout/fragment_dev_byte_0".equals(tag)) {
            return new FragmentDevByteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_dev_byte is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNOTE: {
          if ("layout/fragment_note_0".equals(tag)) {
            return new FragmentNoteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_note is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "noteViewModel");
      sKeys.put(2, "video");
      sKeys.put(3, "videoCallback");
      sKeys.put(4, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_dev_byte_viewer_0", com.example.android.devbyteviewer.R.layout.activity_dev_byte_viewer);
      sKeys.put("layout/devbyte_item_0", com.example.android.devbyteviewer.R.layout.devbyte_item);
      sKeys.put("layout/fragment_dev_byte_0", com.example.android.devbyteviewer.R.layout.fragment_dev_byte);
      sKeys.put("layout/fragment_note_0", com.example.android.devbyteviewer.R.layout.fragment_note);
    }
  }
}
