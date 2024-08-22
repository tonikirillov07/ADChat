package com.tg.let.utils.animations;

import android.annotation.SuppressLint;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TypeWriter {
    private final TextView textView;
    private final String text;
    private int index;
    private final long delay;

    public TypeWriter(@NonNull TextView textView, String text, long delay) {
        this.textView = textView;
        this.text = text;
        this.index = 0;
        this.delay = delay;

        textView.setText("");
    }

    @SuppressLint("SetTextI18n")
    private void type() {
        if (index < text.length()) {
            textView.setText(textView.getText().toString() + text.charAt(index));
            index++;
            textView.postDelayed(this::type, delay);
        }
    }

    public void animate(){
        type();
    }
}
