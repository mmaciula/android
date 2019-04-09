package com.example.mariusz.zniszczmiasto;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Cities extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ListView listView;
    public static final String CITY = "com.example.mariusz.zniszczmiasto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        listView = findViewById(R.id.list_view);

        String[] cities = {"Warszawa", "Moskwa", "Berlin", "Nowy Jork", "Bruksela", "Londyn"};

        final ArrayList<String> citiesToDestroy = new ArrayList<>();
        citiesToDestroy.addAll(Arrays.asList(cities));

        adapter = new ArrayAdapter<>(this, R.layout.element, citiesToDestroy);

        listView.setAdapter(adapter);

        Toast.makeText(Cities.this, "Pick Target", Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Cities.this, Destroyed.class);
                intent.putExtra(CITY, citiesToDestroy.get(i));

                destroyNotification(citiesToDestroy.get(i));

                startActivity(intent);
            }
        });
    }

    private void destroyNotification(String city) {
        Intent intent = new Intent(Cities.this, Destroyed.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,  intent, 0);

        Notification notification = new NotificationCompat.Builder(this, "channel")
                .setContentText("Nowe powiadomienie!")
                .setContentText("Właśnie zniszczono " + city)
                .setTicker("Zniszczono miasto!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
