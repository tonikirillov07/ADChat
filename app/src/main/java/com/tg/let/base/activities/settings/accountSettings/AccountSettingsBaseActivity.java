package com.tg.let.base.activities.settings.accountSettings;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;

public class AccountSettingsBaseActivity extends AppCompatActivity {
    private Button changeEmailButton, changePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_settings_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        changeEmailButton = findViewById(R.id.changeEmailButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);

        initButtons();
        BackButton.init(this);
    }

    private void initButtons() {
        changePasswordButton.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, PasswordChangingBaseActivity.class, false));
        changeEmailButton.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, EmailChangingBaseActivity.class, false));
    }


}