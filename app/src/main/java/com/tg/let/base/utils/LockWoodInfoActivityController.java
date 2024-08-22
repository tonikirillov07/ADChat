package com.tg.let.base.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tg.let.base.activities.LockWoodExplainActivity;

public final class LockWoodInfoActivityController {
    public static final String LOCKWOOD_ACTIVITY_TITLE_EXTRA = "lockwood_title";
    public static final String LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA = "lockwood_subtext";
    public static final String LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA = "lockwood_main_text";
    public static final String LOCKWOOD_ACTIVITY_DIRECT_ACTIVITY_EXTRA = "direct_activity";
    public static final String LOCKWOOD_ACTIVITY_CLOSE_ALL_PREVIOUS_ACTIVITIES_WHEN_REDIRECTING_EXTRA = "close_others_activity";

    private static final String LOGGER_TAG = LockWoodInfoActivityController.class.getName();

    public static void openActivity(String title, String subText, String mainText, Context context, boolean closeAllPreviousActivities, AppCompatActivityParcelable activityParcelable, boolean closeAnotherActivitiesWhenRedirecting){
        Intent intent = new Intent(context, LockWoodExplainActivity.class);
        intent.putExtra(LOCKWOOD_ACTIVITY_TITLE_EXTRA, title);
        intent.putExtra(LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA, subText);
        intent.putExtra(LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA, mainText);
        intent.putExtra(LOCKWOOD_ACTIVITY_DIRECT_ACTIVITY_EXTRA, activityParcelable);
        intent.putExtra(LOCKWOOD_ACTIVITY_CLOSE_ALL_PREVIOUS_ACTIVITIES_WHEN_REDIRECTING_EXTRA, closeAnotherActivitiesWhenRedirecting);

        if(closeAllPreviousActivities)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);

        Log.i(LOGGER_TAG, "Opened " + LockWoodExplainActivity.class + " with title " + title + ", subtext: " + subText + ", main text: " + mainText);
    }
}
