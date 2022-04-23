// Generated by view binder compiler. Do not edit!
package com.example.storyapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.storyapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListStoryBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imgStory;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView textDate;

  @NonNull
  public final TextView textDescription;

  @NonNull
  public final TextView textNama;

  private ListStoryBinding(@NonNull CardView rootView, @NonNull ImageView imgStory,
      @NonNull LinearLayout linearLayout, @NonNull TextView textDate,
      @NonNull TextView textDescription, @NonNull TextView textNama) {
    this.rootView = rootView;
    this.imgStory = imgStory;
    this.linearLayout = linearLayout;
    this.textDate = textDate;
    this.textDescription = textDescription;
    this.textNama = textNama;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ListStoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListStoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_story, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListStoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.img_story;
      ImageView imgStory = ViewBindings.findChildViewById(rootView, id);
      if (imgStory == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.text_date;
      TextView textDate = ViewBindings.findChildViewById(rootView, id);
      if (textDate == null) {
        break missingId;
      }

      id = R.id.text_description;
      TextView textDescription = ViewBindings.findChildViewById(rootView, id);
      if (textDescription == null) {
        break missingId;
      }

      id = R.id.text_nama;
      TextView textNama = ViewBindings.findChildViewById(rootView, id);
      if (textNama == null) {
        break missingId;
      }

      return new ListStoryBinding((CardView) rootView, imgStory, linearLayout, textDate,
          textDescription, textNama);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}