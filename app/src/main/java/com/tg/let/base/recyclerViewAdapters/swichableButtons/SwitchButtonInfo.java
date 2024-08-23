package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import androidx.annotation.NonNull;

import com.tg.let.utils.actionEvents.IOnSwitchButtonChanging;

import java.util.List;

public class SwitchButtonInfo {
    private String buttonName;
    private int state;
    private final IOnSwitchButtonChanging onSwitchButtonChanging;
    private List<SwitchButtonState> statesList;

    public SwitchButtonInfo(String buttonName, int state, List<SwitchButtonState> statesList, IOnSwitchButtonChanging onSwitchButtonChanging) {
        this.buttonName = buttonName;
        this.state = state;
        this.statesList = statesList;
        this.onSwitchButtonChanging = onSwitchButtonChanging;
    }

    public void switchToNextState(){
        int currentState = state;

        if(currentState + 1 < statesList.size())
            currentState++;
        else
            currentState = 0;

        state = currentState;
        onSwitchButtonChanging.onChanging(state, statesList.get(state));
    }

    public void updateSwitchButton(SwitchButtonAdapter switchButtonAdapter, @NonNull List<SwitchButtonInfo> switchButtonInfos){
        int position = switchButtonInfos.indexOf(this);

        if(position < 0)
            return;

        switchButtonAdapter.notifyItemChanged(position);
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<SwitchButtonState> getStatesList() {
        return statesList;
    }

    public void setStatesList(List<SwitchButtonState> statesList) {
        this.statesList = statesList;
    }

    @NonNull
    @Override
    public String toString() {
        return "SwitchButtonInfo{" +
                "buttonName='" + buttonName + '\'' +
                ", state=" + state +
                ", statesList=" + statesList +
                '}';
    }
}
