package com.example.mariusz.labolatorium1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_class);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.NAME);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
    }
}
