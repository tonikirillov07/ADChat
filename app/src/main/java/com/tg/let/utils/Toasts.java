package com.tg.let.utils;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.pranavpandey.android.dynamic.toasts.DynamicToast;
import com.tg.let.R;

public final class Toasts {
    private static final String LOGGER_TAG = Toasts.class.getName();

    public static void applyToastConfigs(Context context){
        DynamicToast.Config.getInstance()
                .setTextTypeface(ResourcesCompat.getFont(context, R.font.inter_medium))
                .apply();

        Log.i(LOGGER_TAG, "Toasts configs were applied");
    }

    public static void showToast(Context context, String text, int backgroundColor, int icon){
        Toast dynamicToast = DynamicToast.make(context, text, ContextCompat.getDrawable(context, icon),
                context.getColor(R.color.white), context.getResources().getColor(backgroundColor, context.getTheme()), LENGTH_LONG);

        dynamicToast.setGravity(Gravity.TOP, 0, 0);
        dynamicToast.show();

        Log.i(LOGGER_TAG, "Created and shown toast with text '" + text + "', background color: " + backgroundColor + ", icon: " + icon);
    }
}
