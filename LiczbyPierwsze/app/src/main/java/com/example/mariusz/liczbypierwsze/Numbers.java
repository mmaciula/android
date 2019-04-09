package com.example.mariusz.liczbypierwsze;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.NUMBER);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        int number = Integer.valueOf(message);
        if (isPrime(number)) {
            textView.setTextColor(Color.GREEN);
        } else {
            textView.setTextColor(Color.RED);
        }
    }

    private boolean isPrime(int n) {
        int temp;
        for (int i = 2; i <= n/2; i++) {
            temp = n % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }
}
