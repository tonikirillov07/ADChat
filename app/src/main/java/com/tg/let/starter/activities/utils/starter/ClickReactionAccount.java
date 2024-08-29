package com.tg.let.starter.activities.utils.starter;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.tg.let.MainActivity;
import com.tg.let.R;
import com.tg.let.starter.activities.LoginAccountStarter;
import com.tg.let.utils.AnotherActivity;

public class ClickReactionAccount {
    public static void loginAccount(AppCompatActivity appCompatActivity){
        ImageButton imageButtonAccount = appCompatActivity.findViewById(R.id.imageButtonAccount);

        if (imageButtonAccount == null)
            return;

        imageButtonAccount.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(appCompatActivity, LoginAccountStarter.class, false));
    }
}
