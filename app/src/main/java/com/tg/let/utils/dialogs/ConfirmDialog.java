package com.tg.let.utils.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import com.tg.let.R;
import com.tg.let.utils.actionEvents.IOnAction;

public final class ConfirmDialog {
    public static void show(Context context, int text, int icon, IOnAction onAction){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(text);
        builder.setIcon(icon);
        builder.setPositiveButton(R.string.ok, (dialog, whichButton) -> onAction.onAction());
        builder.setNegativeButton(R.string.no, null);
        builder.show();

        Log.i(ConfirmDialog.class.getSimpleName(), "Showed confirm dialog with text " + text + " and icon " + icon);
    }
}
