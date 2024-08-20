package com.tg.let.utils;

import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class BackButton {
    private static final String LOGGER_TAG = BackButton.class.getName();

    public static void init(@NonNull ImageButton backButton){
        backButton.setOnClickListener(v -> ((AppCompatActivity) backButton.getContext()).finish());

        Log.i(LOGGER_TAG, "Back button " + backButton + " initialized");
    }
}
