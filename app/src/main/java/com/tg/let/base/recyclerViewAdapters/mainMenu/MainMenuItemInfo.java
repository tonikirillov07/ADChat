package com.tg.let.base.recyclerViewAdapters.mainMenu;

import com.tg.let.utils.actionEvents.IOnAction;

public class MainMenuItemInfo {
    private String text;
    private int icon;
    private int background;
    private int fontColor;
    private IOnAction action;

    public MainMenuItemInfo(String text, int icon, int background, int fontColor, IOnAction action) {
        this.text = text;
        this.icon = icon;
        this.action = action;
        this.background = background;
        this.fontColor = fontColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public IOnAction getAction() {
        return action;
    }

    public void setAction(IOnAction action) {
        this.action = action;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getFontColor() {
        return fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }
}
