package com.example.android.devbyteviewer;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToDevByte() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_devByte);
  }
}
