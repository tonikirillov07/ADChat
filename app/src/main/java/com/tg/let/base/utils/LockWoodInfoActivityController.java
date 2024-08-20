package com.tg.let.base.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tg.let.base.activities.LockWoodExplainActivity;

public final class LockWoodInfoActivityController {
    public static final String LOCKWOOD_ACTIVITY_TITLE_EXTRA = "lockwood_title";
    public static final String LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA = "lockwood_subtext";
    public static final String LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA = "lockwood_main_text";
    private static final String LOGGER_TAG = LockWoodInfoActivityController.class.getName();

    public static void openActivity(String title, String subText, String mainText, Context context){
        Intent intent = new Intent(context, LockWoodExplainActivity.class);
        intent.putExtra(LOCKWOOD_ACTIVITY_TITLE_EXTRA, title);
        intent.putExtra(LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA, subText);
        intent.putExtra(LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA, mainText);

        context.startActivity(intent);

        Log.i(LOGGER_TAG, "Opened " + LockWoodExplainActivity.class + " with title " + title + ", subtext: " + subText + ", main text: " + mainText);
    }
}
