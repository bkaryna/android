package com.example.projekt2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    Integer clickCounter = 0;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void classicNotificationButtonClicked(View view) {
        showNotification(getBuilder("basic notification", totalClicks()));
    }

    public void customNotificationButtonClicked(View view) {
        String title = "custom notification";
        String text = totalClicks();

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
        remoteViews.setTextViewText(R.id.nTitle, title);
        remoteViews.setTextViewText(R.id.nText, text);

        Notification.Builder builder = getBuilder(title, text);
        builder.setCustomContentView(remoteViews);
        remoteViews.setImageViewResource(R.id.imageRight, R.drawable.cat1);
        remoteViews.setImageViewResource(R.id.imageLeft, R.drawable.cat2);
        showNotification(builder);
    }

    public void classicToastButtonClicked(View view) {

    }

    public void customToastButtonClicked(View view) {

    }


    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel("channel_ID", "name", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("description");
        notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    private void showNotification(Notification.Builder builder) {
        //notificationManager.notify(clickCounter, builder.build()); //new notification each time
        notificationManager.notify(0, builder.build()); //overwriting notification
    }

    private Notification.Builder getBuilder(String title, String text) {
        return new Notification.Builder(this, "channel_ID")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(text);
    }

    private String totalClicks() {
        return "total clicks on project2 so far: " + ++clickCounter;
    }

}
