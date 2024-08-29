package com.tg.let.base.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.Utils;
import com.tg.let.utils.animations.TypeWriter;

public class LessonsHubMainActivity extends AppCompatActivity {
    private TextView englishFactTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lessons_hub_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        englishFactTextView = findViewById(R.id.factTextView);

        BackButton.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initFacts();
    }

    private void initFacts() {
        TypeWriter typeWriter = new TypeWriter(englishFactTextView, Utils.convertStringToQuotation(Utils.getRandomStringFromTextFile(getResources().openRawResource(R.raw.english_facts), this)), 30);
        typeWriter.animate();
    }
}