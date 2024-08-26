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
import com.tg.let.base.utils.AppCompatActivityParcelable;
import com.tg.let.base.utils.LockWoodInfoActivityController;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.Utils;
import com.tg.let.utils.animations.TypeWriter;

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
        initActionOnNextButton(intent);

        animateText();
    }

    private void animateText() {
        TypeWriter typeWriter = new TypeWriter(lockwoodTextTextView, lockwoodTextTextView.getText().toString(), 25);
        typeWriter.animate();
    }

    private void initActionOnNextButton(@NonNull Intent intent) {
        AppCompatActivityParcelable activityParcelable = intent.getParcelableExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_DIRECT_ACTIVITY_EXTRA);

        nextButton.setOnClickListener(v -> {
            if(activityParcelable == null){
                finish();
                return;
            }

            if(intent.getBooleanExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_CLOSE_ALL_PREVIOUS_ACTIVITIES_WHEN_REDIRECTING_EXTRA, false))
                AnotherActivity.gotoAnotherActivityWithClosingAllPrevious(this, activityParcelable.getActivityData());
            else
                AnotherActivity.gotoAnotherActivity(this, activityParcelable.getActivityData(), false);
        });
    }

    private void setTexts(@NonNull Intent intent) {
        titleTextView.setText(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_TITLE_EXTRA));
        subTextTextView.setText(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_SUBTEXT_EXTRA));
        lockwoodTextTextView.setText(Utils.convertStringToQuotation(intent.getStringExtra(LockWoodInfoActivityController.LOCKWOOD_ACTIVITY_MAIN_TEXT_EXTRA)));
    }
}