package com.tg.let.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import org.jetbrains.annotations.Contract;

public final class Utils {
    private static final String LOGGER_TAG = Utils.class.getName();

    @NonNull
    @Contract(pure = true)
    public static String convertStringToQuotation(String string){
        Log.i(LOGGER_TAG, "String " + string + " converted to quotation");

        return "“" + string + "”";
    }

    public static Drawable getDrawableById(int drawableId, @NonNull Context context){
        return ResourcesCompat.getDrawable(context.getResources(), drawableId, context.getTheme());
    }
}
