package com.tg.let.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public final class Utils {
    private static final String LOGGER_TAG = Utils.class.getName();

    @NonNull
    @Contract(pure = true)
    public static String convertStringToQuotation(String string){
        Log.i(LOGGER_TAG, "String " + string + " converted to quotation");

        return "“" + string + "”";
    }
}
