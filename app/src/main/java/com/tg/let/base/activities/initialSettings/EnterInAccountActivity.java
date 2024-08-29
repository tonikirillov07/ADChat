package com.tg.let.base.activities.initialSettings;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.tg.let.R;
import com.tg.let.base.activities.MenuBaseActivity;
import com.tg.let.base.activities.settings.accountSettings.PasswordRestoringBaseActivity;
import com.tg.let.base.utils.AppCompatActivityParcelable;
import com.tg.let.base.utils.LockWoodInfoActivityController;
import com.tg.let.utils.AnotherActivity;
import com.tg.let.utils.BackButton;
import com.tg.let.utils.EditTextUtils;

public class EnterInAccountActivity extends AppCompatActivity {
    private EditText emailEditText;
    private TextInputLayout passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_in_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.backButton);
        Button forgotPasswordButton = findViewById(R.id.forgotPasswordButton);
        Button buttonNext = findViewById(R.id.buttonNext);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        forgotPasswordButton.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, PasswordRestoringBaseActivity.class, false));
        buttonNext.setOnClickListener(v -> onButtonNextAction());
        BackButton.init(backButton);
    }

    private void onButtonNextAction(){
        if(EditTextUtils.hasEmptyFieldsInArrays(new EditText[]{emailEditText}, new TextInputLayout[]{passwordEditText}, this))
            return;

        AppCompatActivityParcelable activityParcelable = new AppCompatActivityParcelable(MenuBaseActivity.class);
        LockWoodInfoActivityController.openActivity(getString(R.string.welcome_back), getString(R.string.welcome_back_user) + EditTextUtils.getTextFromEditText(emailEditText),
                getString(R.string.glad_to_see_you_again), this, true, activityParcelable, true);
    }
}