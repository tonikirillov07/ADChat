package com.tg.let.base.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.base.utils.LockWoodInfoActivityController;
import com.tg.let.utils.Utils;

public class LockWoodExplainActivity extends AppCompatActivity {
    private TextView titleTextView, subTextTextView, lockwoodTextTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lock_wood_explain);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titleTextView = findViewById(R.id.titleTextView);
        subTextTextView = findViewById(R.id.subTextTextView);
        lockwoodTextTextView = findViewById(R.id.lockwoodTextTextView);
        nextButton = findViewById(R.id.nextButton);

        Intent intent = getIntent();

        setTexts(intent);
        initActionOnNextButton();
    }

    private void initActionOnNextButton() {
        nextButton.setOnClickListener(v -> finish());
    }

    private void setTexts(@NonNull Intent intent) {
        titleTextView.setText(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_TITLE_EXTRA));
        subTextTextView.setText(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA));
        lockwoodTextTextView.setText(Utils.convertStringToQuotation(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA)));
    }
}