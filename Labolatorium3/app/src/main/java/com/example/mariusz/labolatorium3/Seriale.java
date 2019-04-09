package com.example.mariusz.labolatorium3;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Seriale extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seriale);

        list = findViewById(R.id.listView);

        String[] serials = {"Stranger Things", "Doctor Who", "Jessica Jones", "Daredevil", "IT Crowd", "Utopia"};

        final ArrayList<String> listOfSerials = new ArrayList<>();
        listOfSerials.addAll(Arrays.asList(serials));

        adapter = new ArrayAdapter<String>(this, R.layout.element, listOfSerials);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Seriale.this, "Skopiowano " + listOfSerials.get(i),
                        Toast.LENGTH_SHORT).show();

                ClipboardManager copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Rezultat", listOfSerials.get(i));
                copy.setPrimaryClip(clipData);
            }
        });
    }
}
