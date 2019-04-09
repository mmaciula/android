package com.example.mariusz.labolatorium2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Lista extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        list = findViewById(R.id.listView);

        String[] marki = {"Mercedes", "Fiat", "Ferrari", "Dacia", "Renault", "Skoda", "Volkswagen", "Audi", "Citroen"};

        ArrayList<String> samochody = new ArrayList<>();
        samochody.addAll(Arrays.asList(marki));

        adapter = new ArrayAdapter<String>(this, R.layout.element, samochody);

        list.setAdapter(adapter);
    }
}
