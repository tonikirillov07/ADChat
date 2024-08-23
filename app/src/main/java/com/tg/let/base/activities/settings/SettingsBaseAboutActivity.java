package com.tg.let.base.activities.settings;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.Constants;
import com.tg.let.R;
import com.tg.let.utils.BackButton;

public class SettingsBaseAboutActivity extends AppCompatActivity {
    private TextView aboutInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_base_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.backButton);
        aboutInfoTextView = findViewById(R.id.aboutInfoTextView);

        writeAppInfo();
        BackButton.init(backButton);
    }

    private void writeAppInfo() {
        String aboutText = getString(R.string.name) + Constants.SPACE + getString(R.string.app_name) + "\n"
                + getString(R.string.version) + Constants.SPACE + getString(R.string.app_version) + "\n"
                + getString(R.string.developer) + Constants.SPACE + getString(R.string.deepapps) + "\n"
                + getString(R.string.sdk_version) + Constants.SPACE + Build.VERSION.SDK_INT;

        aboutInfoTextView.setText(aboutText);
    }
}