package com.example.mariusz.randomnumber;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<String> adapter;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);

        int size = 15;
        int begin = 1;
        int end = 100;
        int[] arrayInt = random.ints(size, begin, end).toArray();
        String[] stringValues = Arrays.stream(arrayInt)
                                      .mapToObj(String::valueOf)
                                      .toArray(String[]::new);

        ArrayList<String> generatedNumbers = new ArrayList<>();
        generatedNumbers.addAll(Arrays.asList(stringValues));

        adapter = new ArrayAdapter<>(this, R.layout.element, generatedNumbers);

        list.setAdapter(adapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this, "Skopiowano " + generatedNumbers.get(i), Toast.LENGTH_SHORT)
                    .show();

            ClipboardManager message = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Copied", generatedNumbers.get(i));
            message.setPrimaryClip(clipData);
        });
    }
}
