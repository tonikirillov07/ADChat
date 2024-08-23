package com.tg.let.base.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tg.let.R;
import com.tg.let.base.recyclerViewAdapters.swichableButtons.SwitchButtonState;

import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public final class SwitchableValues {
    @NonNull
    public static @Unmodifiable List<SwitchButtonState> getOnOffSwitchValues(@NonNull Context context){
        return List.of(new SwitchButtonState(context.getString(R.string.on), context.getColor(R.color.green)),
                new SwitchButtonState(context.getString(R.string.off), context.getColor(R.color.red)));
    }
}
