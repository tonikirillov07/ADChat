package com.tg.let.base.activities.settings;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tg.let.R;
import com.tg.let.base.recyclerViewAdapters.mainMenu.MainMenuItemInfo;
import com.tg.let.base.recyclerViewAdapters.swichableButtons.SwitchButtonAdapter;
import com.tg.let.base.recyclerViewAdapters.swichableButtons.SwitchButtonInfo;
import com.tg.let.base.recyclerViewAdapters.swichableButtons.SwitchButtonState;
import com.tg.let.base.utils.SwitchableValues;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.Toasts;
import com.tg.let.utils.actionEvents.IOnSwitchButtonChanging;

import java.util.ArrayList;
import java.util.List;

public class OthersSettingsBaseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_others_settings_base);
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
        List<SwitchButtonInfo> switchButtonInfoList = new ArrayList<>();
        switchButtonInfoList.add(new SwitchButtonInfo(getString(R.string.sounds), 0, SwitchableValues.getOnOffSwitchValues(this),
                (newStateId, newState) -> Toast.makeText(this, "Sounds changed state to (" + newStateId + ", " + newState + ")", Toast.LENGTH_LONG).show()));
        switchButtonInfoList.add(new SwitchButtonInfo(getString(R.string.notifications), 0, SwitchableValues.getOnOffSwitchValues(this),
                (newStateId, newState) -> Toast.makeText(this, "Notifications changed state to (" + newStateId + ", " + newState + ")", Toast.LENGTH_LONG).show()));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SwitchButtonAdapter(switchButtonInfoList, this));
    }
}