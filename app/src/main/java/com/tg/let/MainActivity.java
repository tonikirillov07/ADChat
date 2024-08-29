package com.tg.let;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.base.activities.initialSettings.WelcomeActivityBase;
import com.tg.let.starter.activities.LoginAccountStarter;
import com.tg.let.starter.activities.QuestionsUserStarter;
import com.tg.let.starter.activities.utils.starter.ClickReactionAccount;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.Toasts;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        AppCompatButton buttonStarter = findViewById(R.id.buttonStarter);
        AppCompatButton buttonBase = findViewById(R.id.buttonBase);

        Toasts.applyToastConfigs(this);

        buttonBase.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, WelcomeActivityBase.class, false));
        buttonStarter.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, QuestionsUserStarter.class, false));
    }


}