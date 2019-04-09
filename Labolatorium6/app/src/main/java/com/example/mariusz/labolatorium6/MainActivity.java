package com.example.mariusz.labolatorium6;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private EditText name, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("TEST_DB", MODE_PRIVATE, null);
        db.execSQL("create table if not exists TEST_TABLE_1"
                + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT," + "Address TEXT)");

        name = findViewById(R.id.editText);
        address = findViewById(R.id.editText1);

        Button add = findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("insert into TEST_TABLE_1 (Name, Address) " + "values ('"+ name.getText().toString() + "','"
                + address.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
            }
        });

        Button display = findViewById(R.id.buttonDisplay);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.rawQuery("select * from TEST_TABLE_1", null);
                String message = "";

                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("Name"));
                    String address = cursor.getString(2);

                    message += name + " " + address + "\n";
                }

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        Button asList = findViewById(R.id.buttonList);
        asList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lista.class);
                startActivity(intent);
            }
        });
    }
}
