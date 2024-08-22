package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;

public class SwitchButtonViewHolder extends RecyclerView.ViewHolder {
    private final TextView settingNameTextView;
    private final TextView stateTextView;

    public SwitchButtonViewHolder(@NonNull View itemView) {
        super(itemView);

        settingNameTextView = itemView.findViewById(R.id.settingNameTextView);
        stateTextView = itemView.findViewById(R.id.stateTextView);


    }

    public TextView getSettingNameTextView() {
        return settingNameTextView;
    }

    public TextView getStateTextView() {
        return stateTextView;
    }
}
