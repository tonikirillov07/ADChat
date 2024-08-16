package com.tg.let.utils;

import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class BackButton {
    public static void init(@NonNull ImageButton backButton){
        backButton.setOnClickListener(v -> ((AppCompatActivity) backButton.getContext()).finish());
    }
}
