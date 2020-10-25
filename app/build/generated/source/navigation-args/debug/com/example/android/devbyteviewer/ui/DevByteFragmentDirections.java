package com.example.android.devbyteviewer.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.android.devbyteviewer.R;

public class DevByteFragmentDirections {
  private DevByteFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDevByteToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_devByte_to_homeFragment);
  }
}
