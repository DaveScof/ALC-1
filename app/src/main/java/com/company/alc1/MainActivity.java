package com.company.alc1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myProfileBtn = findViewById(R.id.button_profile);
        myProfileBtn.setOnClickListener( v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        Button aboutALCBtn = findViewById(R.id.button_about_alc);
        aboutALCBtn.setOnClickListener( v -> {
            Intent intent = new Intent(this, AboutAlcActivity.class);
            startActivity(intent);
        });
    }
}
