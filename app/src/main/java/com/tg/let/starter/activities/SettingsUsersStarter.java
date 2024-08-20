package com.tg.let.starter.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.AdditionalSettings;
import com.tg.let.MainActivity;
import com.tg.let.R;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;

public class SettingsUsersStarter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_users_starter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.buttonBackStarter);
        BackButton.init(backButton);

        AppCompatButton buttonChangeLanguage = findViewById(R.id.buttonChangeLanguage);
        buttonChangeLanguage.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this,ChangeLanguage.class, false));

        AppCompatButton buttonTopic = findViewById(R.id.buttonTopic);
        buttonTopic.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this,Topic.class, false));

        AppCompatButton buttonPaidContent = findViewById(R.id.buttonPaidContent);
        buttonPaidContent.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this,PaidContent.class, false));

        AppCompatButton buttonAdditionalSettings = findViewById(R.id.buttonAdditionalSettings);
        buttonAdditionalSettings.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, AdditionalSettings.class, false));

    }
}