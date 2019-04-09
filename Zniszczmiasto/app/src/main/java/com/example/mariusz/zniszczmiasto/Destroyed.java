package com.example.mariusz.zniszczmiasto;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Destroyed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destroyed);

        TextView textView = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Cities.CITY);

        textView.setText(text);
    }

    public void closeDestroyActivity(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure?");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Destroyed.this, "Another city?", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
