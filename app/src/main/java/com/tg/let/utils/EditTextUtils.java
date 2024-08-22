package com.tg.let.utils;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.tg.let.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class EditTextUtils {
    private static final String LOGGER_TAG = EditTextUtils.class.getSimpleName();

    @NonNull
    public static String getTextFromEditText(@NonNull EditText editText){
        return editText.getText().toString().trim();
    }

    private static void setFieldEmptyError(@NonNull EditText editText, @NonNull Context context){
        editText.setError(context.getText(R.string.fill_this_field));
    }

    private static void setTextInputLayoutError(String error, @NonNull TextInputLayout inputLayout, AppCompatActivity activity){
        inputLayout.setError(error);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            activity.runOnUiThread(() -> inputLayout.setError(null));
        }).start();
    }

    @NonNull
    public static boolean hasEmptyFieldsInArrays(EditText[] editTexts, TextInputLayout[] textInputLayouts, AppCompatActivity activity){
        Log.i(LOGGER_TAG, "Searching empty field from " +  Arrays.toString(editTexts) + " and " +  Arrays.toString(textInputLayouts) + " starting...");

        boolean hasEmptyFields = false;

        if(editTexts != null) {
            for (EditText editText : editTexts) {
                Log.i(LOGGER_TAG, editText + " is empty: " + getTextFromEditText(editText).isEmpty());

                if (getTextFromEditText(editText).isEmpty()) {
                    setFieldEmptyError(editText, activity);
                    hasEmptyFields = true;
                }
            }
        }

        if(textInputLayouts != null) {
            for (TextInputLayout inputLayout : textInputLayouts) {
                Log.i(LOGGER_TAG, "Text Input Layout " + inputLayout + " is empty: " + getTextFromEditText(Objects.requireNonNull(inputLayout.getEditText())));

                if (getTextFromEditText(Objects.requireNonNull(inputLayout.getEditText())).isEmpty()) {
                    setTextInputLayoutError(inputLayout.getContext().getString(R.string.fill_this_field), inputLayout, activity);
                    hasEmptyFields = true;
                }
            }
        }

        Log.i(LOGGER_TAG, "Found empty fields: " + hasEmptyFields);

        return hasEmptyFields;
    }
}
