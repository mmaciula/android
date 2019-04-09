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

public class Filmy extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmy);

        listView = findViewById(R.id.list_view_filmy);

        String[] filmNames = {"Sami swoi", "American Pie", "Psy", "Troja", "Zielona mila", "Ip Man"};

        final ArrayList<String> films = new ArrayList<>();
        films.addAll(Arrays.asList(filmNames));

        adapter = new ArrayAdapter<String>(this, R.layout.element, films);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Filmy.this, "Skopiowano " + films.get(i), Toast.LENGTH_SHORT)
                        .show();

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Result", films.get(i));
                clipboardManager.setPrimaryClip(clipData);
            }
        });
    }
}
