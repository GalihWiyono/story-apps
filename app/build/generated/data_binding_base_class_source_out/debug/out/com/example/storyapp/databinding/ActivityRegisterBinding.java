// Generated by view binder compiler. Do not edit!
package com.example.storyapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.storyapp.R;
import com.example.storyapp.view.customview.CustomEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button daftarBtn;

  @NonNull
  public final CustomEditText emailEdit;

  @NonNull
  public final TextInputLayout emailEditLayout;

  @NonNull
  public final TextView emailText;

  @NonNull
  public final ImageView imgBanner;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final TextView masukMessage;

  @NonNull
  public final TextView masukText;

  @NonNull
  public final TextView messageText;

  @NonNull
  public final CustomEditText nameEdit;

  @NonNull
  public final TextInputLayout nameEditLayout;

  @NonNull
  public final TextView nameText;

  @NonNull
  public final CustomEditText passwordEdit;

  @NonNull
  public final TextInputLayout passwordEditLayout;

  @NonNull
  public final TextView passwordText;

  @NonNull
  public final TextView titleText;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button daftarBtn,
      @NonNull CustomEditText emailEdit, @NonNull TextInputLayout emailEditLayout,
      @NonNull TextView emailText, @NonNull ImageView imgBanner, @NonNull ProgressBar loadingBar,
      @NonNull TextView masukMessage, @NonNull TextView masukText, @NonNull TextView messageText,
      @NonNull CustomEditText nameEdit, @NonNull TextInputLayout nameEditLayout,
      @NonNull TextView nameText, @NonNull CustomEditText passwordEdit,
      @NonNull TextInputLayout passwordEditLayout, @NonNull TextView passwordText,
      @NonNull TextView titleText) {
    this.rootView = rootView;
    this.daftarBtn = daftarBtn;
    this.emailEdit = emailEdit;
    this.emailEditLayout = emailEditLayout;
    this.emailText = emailText;
    this.imgBanner = imgBanner;
    this.loadingBar = loadingBar;
    this.masukMessage = masukMessage;
    this.masukText = masukText;
    this.messageText = messageText;
    this.nameEdit = nameEdit;
    this.nameEditLayout = nameEditLayout;
    this.nameText = nameText;
    this.passwordEdit = passwordEdit;
    this.passwordEditLayout = passwordEditLayout;
    this.passwordText = passwordText;
    this.titleText = titleText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.daftarBtn;
      Button daftarBtn = ViewBindings.findChildViewById(rootView, id);
      if (daftarBtn == null) {
        break missingId;
      }

      id = R.id.emailEdit;
      CustomEditText emailEdit = ViewBindings.findChildViewById(rootView, id);
      if (emailEdit == null) {
        break missingId;
      }

      id = R.id.emailEditLayout;
      TextInputLayout emailEditLayout = ViewBindings.findChildViewById(rootView, id);
      if (emailEditLayout == null) {
        break missingId;
      }

      id = R.id.emailText;
      TextView emailText = ViewBindings.findChildViewById(rootView, id);
      if (emailText == null) {
        break missingId;
      }

      id = R.id.imgBanner;
      ImageView imgBanner = ViewBindings.findChildViewById(rootView, id);
      if (imgBanner == null) {
        break missingId;
      }

      id = R.id.loadingBar;
      ProgressBar loadingBar = ViewBindings.findChildViewById(rootView, id);
      if (loadingBar == null) {
        break missingId;
      }

      id = R.id.masukMessage;
      TextView masukMessage = ViewBindings.findChildViewById(rootView, id);
      if (masukMessage == null) {
        break missingId;
      }

      id = R.id.masukText;
      TextView masukText = ViewBindings.findChildViewById(rootView, id);
      if (masukText == null) {
        break missingId;
      }

      id = R.id.messageText;
      TextView messageText = ViewBindings.findChildViewById(rootView, id);
      if (messageText == null) {
        break missingId;
      }

      id = R.id.nameEdit;
      CustomEditText nameEdit = ViewBindings.findChildViewById(rootView, id);
      if (nameEdit == null) {
        break missingId;
      }

      id = R.id.nameEditLayout;
      TextInputLayout nameEditLayout = ViewBindings.findChildViewById(rootView, id);
      if (nameEditLayout == null) {
        break missingId;
      }

      id = R.id.nameText;
      TextView nameText = ViewBindings.findChildViewById(rootView, id);
      if (nameText == null) {
        break missingId;
      }

      id = R.id.passwordEdit;
      CustomEditText passwordEdit = ViewBindings.findChildViewById(rootView, id);
      if (passwordEdit == null) {
        break missingId;
      }

      id = R.id.passwordEditLayout;
      TextInputLayout passwordEditLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditLayout == null) {
        break missingId;
      }

      id = R.id.passwordText;
      TextView passwordText = ViewBindings.findChildViewById(rootView, id);
      if (passwordText == null) {
        break missingId;
      }

      id = R.id.titleText;
      TextView titleText = ViewBindings.findChildViewById(rootView, id);
      if (titleText == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, daftarBtn, emailEdit,
          emailEditLayout, emailText, imgBanner, loadingBar, masukMessage, masukText, messageText,
          nameEdit, nameEditLayout, nameText, passwordEdit, passwordEditLayout, passwordText,
          titleText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
