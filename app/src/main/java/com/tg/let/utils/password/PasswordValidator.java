package com.tg.let.utils.password;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class PasswordValidator {
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 21;
    public static final int IS_PASSWORD_HARD_KEY = 1;
    public static final int IS_PASSWORD_CONTAINS_DIGITS_KEY = 2;
    public static final int IS_PASSWORD_CONTAINS_UPPER_CASES_KEY = 3;
    public static final int IS_PASSWORD_CONTAINS_LOWER_CASES_KEY = 4;
    public static final int IS_PASSWORD_HAS_NORMAL_LENGTH_KEY = 5;

    public static PasswordStrengthLevels getPasswordStrengthLevel(@NotNull String password){
        return (isLengthNormal(password) && isContainsLowerCases(password) && isContainsUpperCases(password) && isContainsDigits(password)) ? PasswordStrengthLevels.HARD : PasswordStrengthLevels.WEAK;
    }

    @NonNull
    public static HashMap<Integer, Boolean> getPasswordStrengthLevelWithDetails(String password){
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        hashMap.put(IS_PASSWORD_HARD_KEY, getPasswordStrengthLevel(password) == PasswordStrengthLevels.HARD);
        hashMap.put(IS_PASSWORD_CONTAINS_DIGITS_KEY, isContainsDigits(password));
        hashMap.put(IS_PASSWORD_CONTAINS_UPPER_CASES_KEY, isContainsUpperCases(password));
        hashMap.put(IS_PASSWORD_CONTAINS_LOWER_CASES_KEY, isContainsLowerCases(password));
        hashMap.put(IS_PASSWORD_HAS_NORMAL_LENGTH_KEY, isLengthNormal(password));

        return hashMap;
    }

    @Contract(pure = true)
    private static boolean isLengthNormal(@NonNull String password){
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    private static boolean isContainsLowerCases(@NonNull String password){
        return password.matches(".*[a-z].*");
    }

    private static boolean isContainsUpperCases(@NonNull String password){
        return password.matches(".*[A-Z].*");
    }

    private static boolean isContainsDigits(@NonNull String password){
        return password.matches(".*\\d.*");
    }
}
