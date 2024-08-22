package com.tg.let.base.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;
import com.tg.let.base.activities.settings.SettingsMenuBaseActivity;
import com.tg.let.base.recyclerViewAdapters.mainMenu.MainMenuAdapter;
import com.tg.let.base.recyclerViewAdapters.mainMenu.MainMenuItemInfo;
import com.tg.let.utils.AnotherActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuBaseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
    }

    private void initRecyclerView() {
        List<MainMenuItemInfo> mainMenuItemInfoList = new ArrayList<>();
        mainMenuItemInfoList.add(new MainMenuItemInfo(getString(R.string.levels), R.drawable.levels, R.drawable.button_background_white, R.color.black, null));
        mainMenuItemInfoList.add(new MainMenuItemInfo(getString(R.string.settings), R.drawable.settings_base, R.drawable.button_background_white, R.color.black, () -> AnotherActivity.gotoAnotherActivity(this, SettingsMenuBaseActivity.class, false)));

        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(mainMenuItemInfoList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainMenuAdapter);
    }
}