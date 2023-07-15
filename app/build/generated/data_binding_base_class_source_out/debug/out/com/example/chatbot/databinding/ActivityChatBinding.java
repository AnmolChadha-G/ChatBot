// Generated by view binder compiler. Do not edit!
package com.example.chatbot.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.chatbot.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ask;

  @NonNull
  public final LinearLayoutCompat llInput;

  @NonNull
  public final EditText query;

  @NonNull
  public final RecyclerView rcv;

  private ActivityChatBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ask,
      @NonNull LinearLayoutCompat llInput, @NonNull EditText query, @NonNull RecyclerView rcv) {
    this.rootView = rootView;
    this.ask = ask;
    this.llInput = llInput;
    this.query = query;
    this.rcv = rcv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ask;
      ImageView ask = ViewBindings.findChildViewById(rootView, id);
      if (ask == null) {
        break missingId;
      }

      id = R.id.llInput;
      LinearLayoutCompat llInput = ViewBindings.findChildViewById(rootView, id);
      if (llInput == null) {
        break missingId;
      }

      id = R.id.query;
      EditText query = ViewBindings.findChildViewById(rootView, id);
      if (query == null) {
        break missingId;
      }

      id = R.id.rcv;
      RecyclerView rcv = ViewBindings.findChildViewById(rootView, id);
      if (rcv == null) {
        break missingId;
      }

      return new ActivityChatBinding((ConstraintLayout) rootView, ask, llInput, query, rcv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}