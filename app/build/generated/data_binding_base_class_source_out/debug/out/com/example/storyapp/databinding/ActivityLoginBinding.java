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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView daftarMessage;

  @NonNull
  public final TextView daftarText;

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
  public final Button masukBtn;

  @NonNull
  public final TextView messageText;

  @NonNull
  public final CustomEditText passwordEdit;

  @NonNull
  public final TextInputLayout passwordEditLayout;

  @NonNull
  public final TextView passwordText;

  @NonNull
  public final TextView titleText;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView daftarMessage,
      @NonNull TextView daftarText, @NonNull CustomEditText emailEdit,
      @NonNull TextInputLayout emailEditLayout, @NonNull TextView emailText,
      @NonNull ImageView imgBanner, @NonNull ProgressBar loadingBar, @NonNull Button masukBtn,
      @NonNull TextView messageText, @NonNull CustomEditText passwordEdit,
      @NonNull TextInputLayout passwordEditLayout, @NonNull TextView passwordText,
      @NonNull TextView titleText) {
    this.rootView = rootView;
    this.daftarMessage = daftarMessage;
    this.daftarText = daftarText;
    this.emailEdit = emailEdit;
    this.emailEditLayout = emailEditLayout;
    this.emailText = emailText;
    this.imgBanner = imgBanner;
    this.loadingBar = loadingBar;
    this.masukBtn = masukBtn;
    this.messageText = messageText;
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
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.daftarMessage;
      TextView daftarMessage = ViewBindings.findChildViewById(rootView, id);
      if (daftarMessage == null) {
        break missingId;
      }

      id = R.id.daftarText;
      TextView daftarText = ViewBindings.findChildViewById(rootView, id);
      if (daftarText == null) {
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

      id = R.id.masukBtn;
      Button masukBtn = ViewBindings.findChildViewById(rootView, id);
      if (masukBtn == null) {
        break missingId;
      }

      id = R.id.messageText;
      TextView messageText = ViewBindings.findChildViewById(rootView, id);
      if (messageText == null) {
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

      return new ActivityLoginBinding((ConstraintLayout) rootView, daftarMessage, daftarText,
          emailEdit, emailEditLayout, emailText, imgBanner, loadingBar, masukBtn, messageText,
          passwordEdit, passwordEditLayout, passwordText, titleText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}