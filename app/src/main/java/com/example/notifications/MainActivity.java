package com.example.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSimple, btnbigtextnot, btnbigpicturenot, btninboxnot, btnmessagingnot, btnactionnot;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimple = findViewById(R.id.btnSimple);
        btnbigtextnot = findViewById(R.id.btnbigtextnot);
        btnbigpicturenot = findViewById(R.id.btnbigpicturenot);
        btninboxnot = findViewById(R.id.btninboxnot);
        btnmessagingnot = findViewById(R.id.btnmessagingnot);
        btnactionnot = findViewById(R.id.btnactionnot);


        btnSimple.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                simple_notification();

            }
        });
        btnbigtextnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                big_textstyle_Notification();
            }
        });

        btnbigpicturenot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                big_picture_Notification();
            }
        });

        btninboxnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inbox_Notification();
            }
        });
        btnmessagingnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messaging_Notification();
            }
        });

        btnactionnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_Notification();
            }
        });

    }




    @RequiresApi(api = Build.VERSION_CODES.O)
    private void simple_notification() {
        Log.d("method call", "yep");
        int notificationId = 0;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.barber))
                .setContentTitle("Happy coding.")
                .setContentText("Become android developer.")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        //set tone when notification appear

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        //call notification manager so it can build and deleiver

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "name",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());

    }

    private void big_textstyle_Notification() {

        int notificationId = 1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn))
                .setContentTitle("Molana Rumi")
                //set the style of your notification and pass parameters for any specific style
                .setStyle(new NotificationCompat.BigTextStyle().bigText(getResources().getString(R.string.rumi_quote)))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "test",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());

    }

    private void big_picture_Notification() {

        int notificationId = 2;
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn))
                .setContentTitle("dale steyn")
                //style = bigpicture style
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "test",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());
    }

    private void inbox_Notification() {

        int notificationId = 3;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn))
                // you can add lines with different number
                .setStyle(new NotificationCompat.InboxStyle().addLine("Hello").addLine("Are you there ?").setBigContentTitle("2 New Message for you").setSummaryText("Inbox"))
                .setAutoCancel(true);
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "test",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());

    }


    private void messaging_Notification() {

        int notificationId = 4;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn))
                // messaging style notification
                .setStyle(new NotificationCompat.MessagingStyle("Ali: ").setConversationTitle("Q&A Group")
                        .addMessage("This type of notification was introduced in Android N. Right?", 0, "Umar: ")
                        .addMessage("Yes", 0, (CharSequence) null)
                        .addMessage("The constructor is passed with the name of the current user. Right?", 0, "Bilal: ")
                        .addMessage("True", 0, (CharSequence) null))
                .setAutoCancel(true);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "test",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());


    }

    private void action_Notification() {
        int notificationId = 5;
        //init notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.dalesteyn)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.dalesteyn))
                .setContentTitle("Action Buttons")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Click view to visit Google."))
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        //the actions in a notification are handeled through intents
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent);

        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "test",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        notificationManager.notify(notificationId, builder.build());

    }


}
