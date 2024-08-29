package com.tg.let.utils;

import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tg.let.R;
import com.tg.let.utils.dialogs.ErrorDialog;

import org.jetbrains.annotations.NotNull;

public final class BackButton {
    private static final String LOGGER_TAG = BackButton.class.getName();

    public static void init(@NotNull AppCompatActivity activity){
        ImageButton backButton = activity.findViewById(R.id.backButton);

        if(backButton == null){
            ErrorDialog.showDialog(activity, new NullPointerException("No BackButton in " + activity), true);
            return;
        }

        backButton.setOnClickListener(v -> closeActivity(activity));
        Log.i(LOGGER_TAG, "Back button " + backButton + " initialized");
    }

    public static void init(@NonNull ImageButton backButton){
        backButton.setOnClickListener(v -> closeActivity((AppCompatActivity) backButton.getContext()));
    }

    private static void closeActivity(@NonNull AppCompatActivity activity){
        activity.finish();
    }
}
