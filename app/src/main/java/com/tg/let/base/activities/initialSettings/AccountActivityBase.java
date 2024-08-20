package com.tg.let.base.activities.initialSettings;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.tg.let.R;
import com.tg.let.base.utils.LockWoodInfoActivityController;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.EditTextUtils;
import com.tg.let.utils.password.PasswordGenerator;

import java.util.Objects;
import java.util.Random;

public class AccountActivityBase extends AppCompatActivity {
    private EditText emailEditText;
    private TextInputLayout passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonNext = findViewById(R.id.buttonNext);
        Button buttonTryWithoutAccount = findViewById(R.id.buttonTryWithoutAccount);
        ImageButton buttonBack = findViewById(R.id.backButton);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        TextView generateStrongPasswordTextView = findViewById(R.id.generateStrongPasswordTextView);

        generateStrongPasswordTextView.setOnClickListener(v -> generateStrongPassword());
        buttonNext.setOnClickListener(v -> onNextButtonAction());
        BackButton.init(buttonBack);
    }

    private void generateStrongPassword() {
        Objects.requireNonNull(passwordEditText.getEditText()).setText(PasswordGenerator.generateStrongPassword(PasswordGenerator.PASSWORD_RANDOM_LENGTH, true));
    }

    private void onNextButtonAction(){
        if(!EditTextUtils.getEmptyFieldsFromArray(new EditText[]{emailEditText}, new TextInputLayout[]{passwordEditText}, this).isEmpty())
            return;

        LockWoodInfoActivityController.openActivity(getString(R.string.youre_done), getString(R.string.hello) + ", ", getString(R.string.lockwood_welcome), this);
    }
}