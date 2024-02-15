package com.example.gojeklogin;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Customize the status bar color
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = window.getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        // Your original text
        String originalText = "Dengan masuk atau mendaftar, kamu menyetujui Ketentuan layanan dan Kebijakan privasi.";

        // Create a SpannableString
        SpannableString spannableString = new SpannableString(originalText);

        // Define the start and end indices for the text you want to color and make bold
        int startIndex = originalText.indexOf("Ketentuan layanan");
        int endIndex = startIndex + "Ketentuan layanan".length();

        // Set the color and style (bold) for the specified text range
        spannableString.setSpan(
                new ForegroundColorSpan(Color.parseColor("#40A69A")),
                startIndex,
                endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        // Define the start and end indices for the second text you want to color and make bold
        int startIndex2 = originalText.indexOf("Kebijakan privasi");
        int endIndex2 = startIndex2 + "Kebijakan privasi".length();

        // Set the color and style (bold) for the second specified text range
        spannableString.setSpan(
                new ForegroundColorSpan(Color.parseColor("#40A69A")),
                startIndex2,
                endIndex2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        // Set the SpannableString to the TextView
        TextView label = findViewById(R.id.label);
        label.setText(spannableString);
    }
}