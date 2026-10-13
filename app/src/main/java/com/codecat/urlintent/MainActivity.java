package com.codecat.urlintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvHelloWorld;
    ImageButton btnAndroid, btnCodeCat, btnGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAndroid = findViewById(R.id.btnAndroid);
        btnAndroid.setOnClickListener(v ->openURL("https://developer.android.com/"));

        btnCodeCat = findViewById(R.id.btnCodeCat);
        btnCodeCat.setOnClickListener(v ->openURL("https://t.me/cin_ua"));

        btnGitHub = findViewById(R.id.btnGitHub);
        btnGitHub.setOnClickListener(v ->openURL("https://github.com/CodeCatUA/"));
    }

    private void openURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}