package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import androidx.annotation.NonNull;

public class SwitchButtonState {
    private final String stateText;
    private final int stateColor;

    public SwitchButtonState(String stateText, int stateColor) {
        this.stateText = stateText;
        this.stateColor = stateColor;
    }

    public String getStateText() {
        return stateText;
    }

    public int getStateColor() {
        return stateColor;
    }

    @NonNull
    @Override
    public String toString() {
        return "SwitchButtonState{" +
                "stateText='" + stateText + '\'' +
                ", stateColor=" + stateColor +
                '}';
    }
}
