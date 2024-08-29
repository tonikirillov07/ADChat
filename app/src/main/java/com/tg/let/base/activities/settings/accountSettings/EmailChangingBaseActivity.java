package com.tg.let.base.activities.settings.accountSettings;

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
import com.tg.let.utils.BackButton;
import com.tg.let.utils.EditTextUtils;

public class EmailChangingBaseActivity extends AppCompatActivity {
    private EditText newEmailEditText;
    private TextInputLayout passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_email_changing_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonNext = findViewById(R.id.buttonNext);
        newEmailEditText = findViewById(R.id.newEmailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        buttonNext.setOnClickListener(v -> onNextButtonAction());
        BackButton.init(this);
    }

    private void onNextButtonAction(){
        if(EditTextUtils.hasEmptyFieldsInArrays(new EditText[]{newEmailEditText}, new TextInputLayout[]{passwordEditText}, this))
            return;


    }
}