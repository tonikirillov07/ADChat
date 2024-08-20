package com.tg.let.utils.password;

import org.jetbrains.annotations.NotNull;

public class PasswordValidator {
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 21;
    public static final int MIN_CHAT_PASSWORD_LENGTH = 5;

    public static PasswordStrengthLevels getPasswordStrengthLevel(@NotNull String password, boolean isChatPassword){
        int passwordLength = password.length();

        boolean lengthIsNormal = passwordLength >= (isChatPassword ? MIN_CHAT_PASSWORD_LENGTH : MIN_PASSWORD_LENGTH);
        boolean isContainsLowerCaseSymbols = password.matches(".*[a-z].*");
        boolean isContainsUpperCaseSymbols = password.matches(".*[A-Z].*");
        boolean isContainsDigits = password.matches(".*\\d.*");

        return (lengthIsNormal & isContainsDigits & isContainsLowerCaseSymbols & isContainsUpperCaseSymbols) ? PasswordStrengthLevels.HARD : PasswordStrengthLevels.WEAK;
    }
}
