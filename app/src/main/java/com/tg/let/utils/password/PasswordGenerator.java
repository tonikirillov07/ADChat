package com.tg.let.utils.password;

import static com.tg.let.utils.password.PasswordValidator.MAX_PASSWORD_LENGTH;
import static com.tg.let.utils.password.PasswordValidator.MIN_PASSWORD_LENGTH;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class PasswordGenerator {
    private static final String LOGGER_TAG = PasswordGenerator.class.getSimpleName();
    private static char[] allSymbols;
    public static final int PASSWORD_RANDOM_LENGTH = -1;

    @NonNull
    public static String generateStrongPassword(int length, boolean useSpecialSymbols){
        Random random = new Random();

        if(length == PASSWORD_RANDOM_LENGTH)
            length = getRandomLength(random);

        if(length <= 0)
            throw new IllegalArgumentException("Password length cannot be less or equal 0");

        int divisor = useSpecialSymbols ? 4 : 3;
        int chunkSize = length / divisor;

        StringBuilder resultStringBuilder = new StringBuilder();
        generatePreOutStringBuilder(resultStringBuilder, chunkSize, random, useSpecialSymbols);

        char[] preOutResultChars = resultStringBuilder.toString().toCharArray();

        List<Character> characterList = new ArrayList<>();
        for (char preOutResultChar : preOutResultChars) {
            characterList.add(preOutResultChar);
        }

        Collections.shuffle(characterList);

        StringBuilder finallyResult = new StringBuilder();
        for (Character c : characterList) {
            finallyResult.append(c);
        }

        if(finallyResult.length() < length){
            int additionalSymbolsCount = length - finallyResult.length();

            for (int i = 0; i < additionalSymbolsCount; i++) {
                finallyResult.append(allSymbols[random.nextInt(allSymbols.length)]);
            }
        }

        return finallyResult.toString();
    }

    private static void generatePreOutStringBuilder(StringBuilder resultStringBuilder, int chunkSize, Random random, boolean useSpecialSymbols){
        char[] lowerCaseAlphabet = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        char[] upperCaseAlphabet = new String(lowerCaseAlphabet).toUpperCase().toCharArray();
        char[] numbers = "1234567890".toCharArray();
        char[] specialSymbols = useSpecialSymbols ? "[]./,<>|".toCharArray() : new char[0];
        allSymbols = summarizeCharsArrays(List.of(lowerCaseAlphabet, upperCaseAlphabet, numbers, specialSymbols));

        for (int j = 0; j < chunkSize; j++) {
            resultStringBuilder.append(lowerCaseAlphabet[random.nextInt(lowerCaseAlphabet.length)]);
        }

        for (int j = 0; j < chunkSize; j++) {
            resultStringBuilder.append(upperCaseAlphabet[random.nextInt(upperCaseAlphabet.length)]);
        }

        for (int j = 0; j < chunkSize; j++) {
            resultStringBuilder.append(numbers[random.nextInt(numbers.length)]);
        }

        if(useSpecialSymbols) {
            for (int j = 0; j < chunkSize; j++) {
                resultStringBuilder.append(specialSymbols[random.nextInt(specialSymbols.length)]);
            }
        }
    }

    @NonNull
    private static char[] summarizeCharsArrays(@NonNull List<char[]> chars){
        List<Character> characterList = new ArrayList<>();

        chars.forEach(charsChunk -> {
            if (charsChunk != null) {
                for (char c : charsChunk) {
                    characterList.add(c);
                }
            }
        });

        char[] charsDefaultArray = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++) {
            charsDefaultArray[i] = characterList.get(i);
        }

        return charsDefaultArray;
    }

    private static int getRandomLength(@NonNull Random random){
        int length = random.nextInt(MAX_PASSWORD_LENGTH);

        if(length < MIN_PASSWORD_LENGTH)
            length = MIN_PASSWORD_LENGTH;

        Log.i(LOGGER_TAG, "Defined length for password: " + length);

        return length;
    }
}
