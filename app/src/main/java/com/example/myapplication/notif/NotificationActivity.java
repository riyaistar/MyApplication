package com.example.myapplication.notif;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {
    @BindView(R.id.comment)
    public TextView notifComment;
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "secondary channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            notifComment.setText(getIntent().getStringExtra("reply"));
        }
    }

    @OnClick(R.id.notifButton)
    public void sendNotification() {
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, SECONDARY_CHANNEL);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Much longer text that cannot fit one line...");
        mBuilder.setColor(getResources().getColor(R.color.theme_color));
        mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH); //for heads-up
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setAutoCancel(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);

            mBuilder.setColor(Color.RED);
        } else {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);
        }

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;   //heads-up
            NotificationChannel channel = new NotificationChannel(SECONDARY_CHANNEL, name, importance);
            channel.enableLights(true);
            channel.setLightColor(getResources().getColor(R.color.theme_color));
            channel.enableVibration(true);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this

            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel);

        }
// notificationId is a unique int for each notification that you must define
        notificationManager.notify(123, mBuilder.build());
    }


    @OnClick(R.id.replyNotif)
    public void InlineReply() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(NotificationKeyStore.CHANNNEL_ID, NotificationKeyStore.CHANNEL_NAME, importance);
            channel.setDescription(NotificationKeyStore.CHANNEL_DESC);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(channel);
        }



        PendingIntent approvePendingIntent = PendingIntent.getBroadcast(
                NotificationActivity.this,
                NotificationKeyStore.REQUEST_CODE_APPROVE,
                new Intent(NotificationActivity.this, NotificationBroadcastReceiver.class)
                        .putExtra(NotificationKeyStore.KEY_INTENT_APPROVE, NotificationKeyStore.REQUEST_CODE_APPROVE),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        //Pending intent for a notification button disapprove
        PendingIntent dissaprovePendingIntent = PendingIntent.getBroadcast(
                NotificationActivity.this,
                NotificationKeyStore.REQUEST_CODE_DISAPPROVE,
                new Intent(NotificationActivity.this, NotificationBroadcastReceiver.class)
                        .putExtra(NotificationKeyStore.KEY_INTENT_DISAPPROVE, NotificationKeyStore.REQUEST_CODE_DISAPPROVE),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        //Creating the notification builder object
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, NotificationKeyStore.CHANNNEL_ID)
                .setSmallIcon(R.mipmap.app_icon)
                .setContentTitle("New Lead Added")
                .setContentText("Associate added a lead.")
                .setAutoCancel(true)
                .setColor(getResources().getColor(R.color.theme_color))
                .setContentIntent(dissaprovePendingIntent)
                .addAction(R.drawable.ic_done_white_24dp, "Approve", approvePendingIntent)
                .addAction(R.drawable.ic_close_white_24dp, "Disapprove", dissaprovePendingIntent);
                //.addAction(action);


        //finally displaying the notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());

    }

    @OnClick(R.id.twoButton)
    public void twoButtonNotification(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(NotificationKeyStore.CHANNNEL_ID, NotificationKeyStore.CHANNEL_NAME, importance);
            channel.setDescription(NotificationKeyStore.CHANNEL_DESC);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mNotificationManager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                NotificationActivity.this,
                NotificationKeyStore.REQUEST_CODE_APPROVE,
                new Intent(NotificationActivity.this, NotificationBroadcastReceiver.class)
                        .putExtra(NotificationKeyStore.KEY_INTENT_APPROVE, NotificationKeyStore.REQUEST_CODE_APPROVE),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        //We need this object for getting direct input from notification
        RemoteInput remoteInput = new RemoteInput.Builder(NotificationKeyStore.NOTIFICATION_REPLY)
                .setLabel("Comment...")
                .build();


        //For the remote input we need this action object
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.ic_done_white_24dp,
                        "Add A Comment", pendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

        //Creating the notification builder object
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, NotificationKeyStore.CHANNNEL_ID)
                .setSmallIcon(R.mipmap.app_icon)
                .setContentTitle("New Lead Added")
                .setContentText("Associate added a lead.")
                .setAutoCancel(true)
                .setColor(getResources().getColor(R.color.theme_color))
                //.setContentIntent(pendingIntent);
               .addAction(action);


        //finally displaying the notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());


    }

}