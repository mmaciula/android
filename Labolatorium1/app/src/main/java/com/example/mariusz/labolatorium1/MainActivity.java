package com.example.mariusz.labolatorium1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public final static String NAME = "com.example.mariusz.labolatorium1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void intDescription(View view) {
        Intent intent = new Intent(this, IntClass.class);
        startActivity(intent);
    }

    public void stringDescription(View view) {
        Intent intent = new Intent(this, StringType.class);
        startActivity(intent);
    }

    public void boolDescription(View view) {
        Intent intent = new Intent(this, BooleanClass.class);
        startActivity(intent);
    }

    public void doubleDescription(View view) {
        Intent intent = new Intent(this, DoubleClass.class);
        startActivity(intent);
    }

    /*public void newActivity(View view) {
        Intent intent = new Intent(this, NewClass.class);

        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();

        intent.putExtra(NAME, message);

        startActivity(intent);
    }*/
}
