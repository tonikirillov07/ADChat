package com.tg.let.base.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.utils.AnotherActivity;

public class WelcomeActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, QuestionsActivityBase.class, false));

        TextView haveAccountTextView = findViewById(R.id.haveAccountTextView);
        haveAccountTextView.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, EnterInAccountActivity.class, false));
    }
}