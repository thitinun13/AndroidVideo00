// Generated by data binding compiler. Do not edit!
package com.example.android.devbyteviewer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.android.devbyteviewer.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityDevByteViewerBinding extends ViewDataBinding {
  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final NavigationView navView;

  protected ActivityDevByteViewerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      DrawerLayout drawerLayout, NavigationView navView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.drawerLayout = drawerLayout;
    this.navView = navView;
  }

  @NonNull
  public static ActivityDevByteViewerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_dev_byte_viewer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDevByteViewerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityDevByteViewerBinding>inflateInternal(inflater, R.layout.activity_dev_byte_viewer, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDevByteViewerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_dev_byte_viewer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityDevByteViewerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityDevByteViewerBinding>inflateInternal(inflater, R.layout.activity_dev_byte_viewer, null, false, component);
  }

  public static ActivityDevByteViewerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityDevByteViewerBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityDevByteViewerBinding)bind(component, view, R.layout.activity_dev_byte_viewer);
  }
}