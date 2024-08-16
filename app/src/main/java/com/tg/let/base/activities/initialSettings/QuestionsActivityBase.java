package com.tg.let.base.activities.initialSettings;

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

public class QuestionsActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questions_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton buttonBack = findViewById(R.id.backButton);
        Button buttonNext = findViewById(R.id.buttonNext);

        BackButton.init(buttonBack, WelcomeActivityBase.class, false);
        buttonNext.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, AccountActivityBase.class, false));
    }
}