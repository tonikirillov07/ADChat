package com.tg.let.base.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tg.let.R;
import com.tg.let.utils.Toasts;
import com.tg.let.utils.password.PasswordValidator;

import java.util.HashMap;

public final class PasswordWeaknessReasonsDisplayer {
    public static boolean checkIsPasswordWeakAndDisplayInfoToast(Context context, String password) {
        HashMap<Integer, Boolean> passwordStrengthHashMap = PasswordValidator.getPasswordStrengthLevelWithDetails(password);

        boolean isWeak = Boolean.FALSE.equals(passwordStrengthHashMap.get(PasswordValidator.IS_PASSWORD_HARD_KEY));
        if(isWeak)
            showPasswordWeakInfoInToast(passwordStrengthHashMap, context);

        return isWeak;
    }

    private static void showPasswordWeakInfoInToast(@NonNull HashMap<Integer, Boolean> passwordStrengthHashMap, Context context) {
        StringBuilder weakInfoStringBuilder = new StringBuilder();

        putWeakInfoTextIntoStringBuilder(weakInfoStringBuilder, passwordStrengthHashMap, context);
        markEveryReasonWithNumber(weakInfoStringBuilder);

        Toasts.showErrorToast(context, new StringBuilder(weakInfoStringBuilder).deleteCharAt(0).toString().trim());
    }

    private static void markEveryReasonWithNumber(@NonNull StringBuilder weakInfoStringBuilder) {
        String[] reasons = weakInfoStringBuilder.toString().split("\n");
        weakInfoStringBuilder.delete(0, weakInfoStringBuilder.length() - 1);

        int reasonNumber = 0;

        for (String reason : reasons) {
            if(reason.isEmpty())
                continue;

            weakInfoStringBuilder.append("\n").append(reasons.length - 1 == 1 ? "" : (reasonNumber + 1) + ". ").append(reason);
            reasonNumber++;
        }
    }

    private static void putWeakInfoTextIntoStringBuilder(StringBuilder weakInfoStringBuilder, @NonNull HashMap<Integer, Boolean> passwordStrengthHashMap, Context context) {
        if(Boolean.FALSE.equals(passwordStrengthHashMap.get(PasswordValidator.IS_PASSWORD_HAS_NORMAL_LENGTH_KEY)))
            weakInfoStringBuilder.append("\n").append(context.getString(R.string.password_must_have_a_length_at_least)).append(" ").append(PasswordValidator.MIN_PASSWORD_LENGTH).append(" ").append(context.getString(R.string.symbols));

        if(Boolean.FALSE.equals(passwordStrengthHashMap.get(PasswordValidator.IS_PASSWORD_CONTAINS_LOWER_CASES_KEY)))
            weakInfoStringBuilder.append("\n").append(context.getString(R.string.password_must_contains_lower_cases));

        if(Boolean.FALSE.equals(passwordStrengthHashMap.get(PasswordValidator.IS_PASSWORD_CONTAINS_UPPER_CASES_KEY)))
            weakInfoStringBuilder.append("\n").append(context.getString(R.string.password_must_contains_upper_cases));

        if(Boolean.FALSE.equals(passwordStrengthHashMap.get(PasswordValidator.IS_PASSWORD_CONTAINS_DIGITS_KEY)))
            weakInfoStringBuilder.append("\n").append(context.getString(R.string.password_must_contains_digits));
    }
}

