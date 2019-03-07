package com.example.myapplication.notif;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;


public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //getting the remote input bundle from intent
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);

        //if there is some input
        if (remoteInput != null) {

            //getting the input value
            CharSequence reply = remoteInput.getCharSequence(NotificationKeyStore.NOTIFICATION_REPLY);

            //updating the notification with the input value
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NotificationKeyStore.CHANNNEL_ID)
                    .setSmallIcon(android.R.drawable.ic_menu_info_details)
                    .setContentTitle("Comment: " + reply);
            NotificationManager notificationManager = (NotificationManager) context.
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());
        }

        //if disaprove button is clicked
        if (intent.getIntExtra(NotificationKeyStore.KEY_INTENT_DISAPPROVE, -1) == NotificationKeyStore.REQUEST_CODE_DISAPPROVE) {
            Toast.makeText(context, "Lead Dissaproved", Toast.LENGTH_LONG).show();
        }

        //if approve button is clicked
        if (intent.getIntExtra(NotificationKeyStore.KEY_INTENT_APPROVE, -1) == NotificationKeyStore.REQUEST_CODE_APPROVE) {
            Toast.makeText(context, "Lead Approved", Toast.LENGTH_LONG).show();
        }
    }
}