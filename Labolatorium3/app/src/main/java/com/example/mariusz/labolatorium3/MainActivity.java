package com.example.mariusz.labolatorium3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initSerialeActivity(View v) {
        Intent intent = new Intent(this, Seriale.class);
        startActivity(intent);
    }

    public void initFilmActivity(View v) {
        Intent intent = new Intent(this, Filmy.class);
        startActivity(intent);
    }

    public void close(View view) {
        AlertDialog.Builder message = new AlertDialog.Builder(this);
        message.setMessage("Are you sure?");

        message.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        message.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "I'm Happy you stay", Toast.LENGTH_SHORT).show();
            }
        });

        message.setNeutralButton("I don't know", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "I'll think", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = message.create();
        alertDialog.show();
    }
}
