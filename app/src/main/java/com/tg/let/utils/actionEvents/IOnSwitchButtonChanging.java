package com.tg.let.utils.actionEvents;

import com.tg.let.base.recyclerViewAdapters.swichableButtons.SwitchButtonState;

public interface IOnSwitchButtonChanging {
    void onChanging(int newStateId, SwitchButtonState newState);
}
