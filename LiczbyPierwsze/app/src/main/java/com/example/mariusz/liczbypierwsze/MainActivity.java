package com.example.mariusz.liczbypierwsze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String NUMBER = "com.example.mariusz.liczbypierwsze";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initCheckNumber(View view) {
        Intent intent = new Intent(this, Numbers.class);

        EditText givenNumber = findViewById(R.id.editText2);
        String message = givenNumber.getText().toString();

        intent.putExtra(NUMBER, message);

        startActivity(intent);
    }
}
