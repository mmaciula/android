package com.example.mariusz.labolatorium2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initRGBActivity(View view) {
        Intent intent = new Intent(this, RGB.class);

        startActivity(intent);
    }

    public void initListaActivity(View view) {
        Intent intent = new Intent(this, Lista.class);

        startActivity(intent);
    }

    public void initCMYK(View view) {
        Intent intent = new Intent(this, CMYK.class);

        startActivity(intent);
    }
}
