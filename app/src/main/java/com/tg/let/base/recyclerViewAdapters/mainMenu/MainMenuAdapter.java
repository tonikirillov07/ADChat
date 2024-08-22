package com.tg.let.base.recyclerViewAdapters.mainMenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;
import com.tg.let.utils.Utils;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder> {
    private final List<MainMenuItemInfo> mainMenuItemInfoList;
    private final Context context;

    public MainMenuAdapter(List<MainMenuItemInfo> mainMenuItemInfoList, Context context) {
        this.mainMenuItemInfoList = mainMenuItemInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_item_base, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
        MainMenuItemInfo mainMenuItemInfo = mainMenuItemInfoList.get(position);

        Drawable drawableEnd = Utils.getDrawableById(mainMenuItemInfo.getIcon(), context);
        Drawable background = Utils.getDrawableById(mainMenuItemInfo.getBackground(), context);
        Button button = holder.getButton();

        button.setText(mainMenuItemInfo.getText());
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableEnd, null);
        button.setBackground(background);
        button.setTextColor(context.getColor(mainMenuItemInfo.getFontColor()));
        button.setOnClickListener(v -> {
            if(mainMenuItemInfo.getAction() == null)
                return;

            mainMenuItemInfo.getAction().onAction();
        });
    }

    @Override
    public int getItemCount() {
        return mainMenuItemInfoList.size();
    }
}
