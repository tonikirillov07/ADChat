package com.tg.let.utils;

import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.tg.let.utils.dialogs.ErrorDialog;

public final class AnotherActivity {
    private static final String LOGGER_TAG = AnotherActivity.class.getName();

    public static void gotoAnotherActivity(AppCompatActivity context, Class activityClass, boolean closePrevious){
        try {
            Intent intent = new Intent(context, activityClass);

            if (closePrevious)
                context.finish();

            context.startActivity(intent);

            Log.i(LOGGER_TAG, context.getLocalClassName() + " redirected to activity " + activityClass);
        }catch (Exception e){
            ErrorDialog.showDialog(context, e, true);
        }
    }

    public static void gotoAnotherActivityWithClosingAllPrevious(AppCompatActivity context, Class activityClass){
        try {
            Intent intent = new Intent(context, activityClass);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            Log.i(LOGGER_TAG, context.getLocalClassName() + " redirected to activity " + activityClass + " with clear activities stack");
        }catch (Exception e){
            ErrorDialog.showDialog(context, e, true);
        }
    }
}
