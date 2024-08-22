package com.tg.let.base.recyclerViewAdapters.mainMenu;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;

public class MainMenuViewHolder extends RecyclerView.ViewHolder {
    private final Button button;

    public MainMenuViewHolder(@NonNull View itemView) {
        super(itemView);

        button = itemView.findViewById(R.id.itemButton);
    }

    public Button getButton() {
        return button;
    }
}
