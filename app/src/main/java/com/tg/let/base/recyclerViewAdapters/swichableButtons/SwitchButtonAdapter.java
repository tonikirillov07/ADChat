package com.tg.let.base.recyclerViewAdapters.swichableButtons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;

import java.util.List;

public class SwitchButtonAdapter extends RecyclerView.Adapter<SwitchButtonViewHolder> {
    private final List<SwitchButtonInfo> switchButtonInfos;
    private final Context context;

    public SwitchButtonAdapter(List<SwitchButtonInfo> switchButtonInfos, Context context) {
        this.switchButtonInfos = switchButtonInfos;
        this.context = context;
    }

    @NonNull
    @Override
    public SwitchButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SwitchButtonViewHolder(LayoutInflater.from(context).inflate(R.layout.swichable_button_item_base, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SwitchButtonViewHolder holder, int position) {
        SwitchButtonInfo switchButtonInfo = switchButtonInfos.get(position);

        holder.getSettingNameTextView().setText(switchButtonInfo.getButtonName());
        changeState(holder.getStateTextView(), position, switchButtonInfo.getState());
    }

    @Override
    public int getItemCount() {
        return switchButtonInfos.size();
    }

    private void changeState(@NonNull TextView stateTextView, int position, int state){
        stateTextView.setText(switchButtonInfos.get(position).getStatesList().get(state));
    }
}
