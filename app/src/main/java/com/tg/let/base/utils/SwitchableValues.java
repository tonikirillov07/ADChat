package com.tg.let.base.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tg.let.R;

import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public final class SwitchableValues {
    @NonNull
    public static @Unmodifiable List<String> getOnOffSwitchValues(@NonNull Context context){
        return List.of(context.getString(R.string.on), context.getString(R.string.off));
    }
}
