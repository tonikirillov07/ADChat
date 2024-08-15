package com.tg.let.utils;

import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class BackButton {
    public static void init(@NonNull ImageButton backButton, Class targetActivity, boolean closeCurrent){
        backButton.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity((AppCompatActivity) backButton.getContext(), targetActivity, closeCurrent));
    }
}
