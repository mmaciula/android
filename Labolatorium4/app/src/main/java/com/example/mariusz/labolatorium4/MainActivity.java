package com.example.mariusz.labolatorium4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String CHANNEL_ID = "MY_CH_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        Button powiadomienie = findViewById(R.id.button);
        powiadomienie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleNotification();
            }
        });

        Button powiadomienieRozszerzone = findViewById(R.id.button3);
        powiadomienieRozszerzone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extendedNotification();
            }
        });

        Button powiadomienieAkcja = findViewById(R.id.button4);
        powiadomienieAkcja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionNotification();
            }
        });
    }

    private void simpleNotification() {
        Intent intent = new Intent(this, Rezultat.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("Cześć, jestem prostym powiadomieniem")
                .setTicker("Hello!")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setLargeIcon(icon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    private void extendedNotification() {
        Intent intent = new Intent(this, Rezultat.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        String[] messagePosition = new String [3];
        messagePosition[0] = "pierwsze";
        messagePosition[1] = "drugie";
        messagePosition[2] = "trzecie";

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Pozycje wiadomości:");

        for (int i = 0; i < messagePosition.length; i++) {
            inboxStyle.addLine(messagePosition[i]);
        }

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Nowe Powiadomienie!")
                .setContentText("Cześć, jestem nowym powiadomieniem")
                .setTicker("Hello!")
                .setAutoCancel(true)
                .setStyle(inboxStyle)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    private void actionNotification() {
        Intent intent = new Intent(this, Rezultat.class);
        Intent actionIntent = new Intent(this, RezultatAkcji.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        PendingIntent pendingActionIntent = PendingIntent.getActivity(this, 0, actionIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Nowe powiadomienie!")
                .setContentText("Cześć, jestem powiadomieniem z akcją!")
                .setTicker("Hello!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_launcher_foreground, "Akcja", pendingActionIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
