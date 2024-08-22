package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import java.util.List;

public class SwitchButtonInfo {
    private String buttonName;
    private int state;
    private List<String> statesList;

    public SwitchButtonInfo(String buttonName, int state, List<String> statesList) {
        this.buttonName = buttonName;
        this.state = state;
        this.statesList = statesList;
    }

    public void switchToNextState(){
        int currentState = state;

        if(currentState + 1 < statesList.size())
            currentState++;
        else
            currentState = 0;

        state = currentState;
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

    public List<String> getStatesList() {
        return statesList;
    }

    public void setStatesList(List<String> statesList) {
        this.statesList = statesList;
    }
}
