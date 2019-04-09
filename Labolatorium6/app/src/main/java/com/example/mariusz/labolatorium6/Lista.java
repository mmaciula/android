package com.example.mariusz.labolatorium6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    private SQLiteDatabase db;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        db = openOrCreateDatabase("TEST_DB", MODE_PRIVATE, null);
        db.execSQL("create table if not exists TEST_TABLE_1"
                + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT," + "Address TEXT)");

        listView = findViewById(R.id.listView);

        viewData();
    }

    private void viewData() {
        Cursor cursor = db.rawQuery("select * from TEST_TABLE_1", null);
        ArrayList<String> listItem = new ArrayList<>();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "Nothing to display", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<String>(this, R.layout.element, listItem);
            listView.setAdapter(adapter);
        }
    }
}
