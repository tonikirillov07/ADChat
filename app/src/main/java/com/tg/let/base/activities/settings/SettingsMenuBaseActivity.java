package com.tg.let.base.activities.settings;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;
import com.tg.let.base.activities.settings.accountSettings.AccountSettingsBaseActivity;
import com.tg.let.base.recyclerViewAdapters.mainMenu.MainMenuAdapter;
import com.tg.let.base.recyclerViewAdapters.mainMenu.MainMenuItemInfo;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;

import java.util.ArrayList;
import java.util.List;

public class SettingsMenuBaseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_menu_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.backButton);
        recyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        BackButton.init(backButton);
    }

    private void initRecyclerView() {
        List<MainMenuItemInfo> mainMenuItemInfoList = new ArrayList<>();
        mainMenuItemInfoList.add(new MainMenuItemInfo(getString(R.string.account), R.drawable.account_3, R.drawable.light_gray_button_background, R.color.white, () -> openSettingsSection(AccountSettingsBaseActivity.class)));
        mainMenuItemInfoList.add(new MainMenuItemInfo(getString(R.string.others), R.drawable.others_settings, R.drawable.light_gray_button_background, R.color.white, () -> openSettingsSection(OthersSettingsBaseActivity.class)));
        mainMenuItemInfoList.add(new MainMenuItemInfo(getString(R.string.about), R.drawable.about, R.drawable.light_gray_button_background, R.color.white, () -> openSettingsSection(SettingsBaseAboutActivity.class)));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainMenuAdapter(mainMenuItemInfoList, this));
    }

    private void openSettingsSection(Class activityClass){
        AnotherActivity.gotoAnotherActivity(this, activityClass, false);
    }
}