package com.tg.let.base.activities.settings.accountSettings;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.tg.let.R;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.EditTextUtils;

public class PasswordChangingBaseActivity extends AppCompatActivity {
    private TextInputLayout newPasswordEditText, currentPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_changing_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        currentPasswordEditText = findViewById(R.id.currentPasswordEditText);
        Button buttonNext = findViewById(R.id.buttonNext);
        TextView iLostPasswordTextView = findViewById(R.id.iLostPasswordTextView);

        iLostPasswordTextView.setOnClickListener(v -> onLostPasswordAction());
        buttonNext.setOnClickListener(v -> onNextButtonAction());
        BackButton.init(this);
    }

    private void onNextButtonAction() {
        if(EditTextUtils.hasEmptyFieldsInArrays(null, new TextInputLayout[]{newPasswordEditText, currentPasswordEditText}, this))
            return;

    }

    private void onLostPasswordAction() {
        AnotherActivity.gotoAnotherActivity(this, PasswordRestoringBaseActivity.class, false);
    }
}