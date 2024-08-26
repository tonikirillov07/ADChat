package com.tg.let.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.tg.let.utils.dialogs.ErrorDialog;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Nullable
    public static String getRandomStringFromTextFile(InputStream file, Context context){
        List<String> allLines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null)
                allLines.add(line);

            return allLines.get(new Random().nextInt(allLines.size()));
        }catch (Exception e){
            ErrorDialog.showDialog(context, e, true);
        }

        return null;
    }
}
