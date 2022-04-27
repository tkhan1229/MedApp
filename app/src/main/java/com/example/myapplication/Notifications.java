package com.example.myapplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.Collections;

public class Notifications extends Application {
    public static final String CHANNEL_1_ID = "Appointment";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel Appointment = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Appointment",
                    NotificationManager.IMPORTANCE_HIGH
            );

            Appointment.setDescription("This is appointment");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannels(Collections.singletonList(Appointment));

        }
    };

}
