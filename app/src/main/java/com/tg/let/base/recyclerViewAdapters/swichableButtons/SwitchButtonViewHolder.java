package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;

import java.util.List;

public class SwitchButtonViewHolder extends RecyclerView.ViewHolder {
    private final TextView settingNameTextView;
    private final TextView stateTextView;

    public SwitchButtonViewHolder(@NonNull View itemView, List<SwitchButtonInfo> switchButtonInfos, SwitchButtonAdapter switchButtonAdapter) {
        super(itemView);

        settingNameTextView = itemView.findViewById(R.id.settingNameTextView);
        stateTextView = itemView.findViewById(R.id.stateTextView);

        itemView.setOnClickListener(v -> {
            int position = getAdapterPosition();

            if(position == RecyclerView.NO_POSITION)
                return;

            SwitchButtonInfo switchButtonInfo = switchButtonInfos.get(position);
            switchButtonInfo.switchToNextState();
            switchButtonInfo.updateSwitchButton(switchButtonAdapter, switchButtonInfos);

        });
    }

    public TextView getSettingNameTextView() {
        return settingNameTextView;
    }

    public TextView getStateTextView() {
        return stateTextView;
    }
}
