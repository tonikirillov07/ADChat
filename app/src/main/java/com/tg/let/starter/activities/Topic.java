package com.tg.let.starter.activities;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.base.activities.initialSettings.WelcomeActivityBase;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;

public class Topic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.buttonBackStarter);
        BackButton.init(backButton);

        AppCompatButton buttonStarter = findViewById(R.id.buttonStarter);
        buttonStarter.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, QuestionsUserStarter.class, false));

        AppCompatButton buttonBase = findViewById(R.id.buttonBase);
        buttonBase.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, WelcomeActivityBase.class, false));
    }
}