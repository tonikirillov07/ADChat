package com.tg.let.base.activities.initialSettings;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tg.let.R;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.Toasts;
import com.tg.let.utils.dialogs.ErrorDialog;

public class QuestionsActivityBase extends AppCompatActivity {
    private RadioGroup radioGroup;

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

        radioGroup = findViewById(R.id.radioGroup);
        ImageButton buttonBack = findViewById(R.id.backButton);
        Button buttonNext = findViewById(R.id.buttonNext);

        BackButton.init(buttonBack);
        buttonNext.setOnClickListener(v -> onNextButtonAction());
    }

    private void onNextButtonAction() {
        try {
            int selectedRadioButton = radioGroup.getCheckedRadioButtonId();

            if (selectedRadioButton == RadioGroup.NO_ID)
                Toasts.showErrorToast(this, getString(R.string.please_select_something));
            else
                AnotherActivity.gotoAnotherActivity(this, AccountActivityBase.class, false);
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }
}