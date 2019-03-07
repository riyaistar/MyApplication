package com.example.myapplication.notif;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

import com.example.myapplication.R;


public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //getting the remote input bundle from intent
        Bundle bundleremoteInput = RemoteInput.getResultsFromIntent(intent);

        //if there is some input
        if (bundleremoteInput != null) {

            //getting the input value
            String reply = (bundleremoteInput.getCharSequence(NotificationKeyStore.NOTIFICATION_REPLY)).toString();
            intent = new Intent(context, NotificationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("reply", reply);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NotificationKeyStore.CHANNNEL_ID)
                    .setSmallIcon(R.drawable.app_icon_white)
                    .setColor(context.getResources().getColor(R.color.theme_color))
                    .setContentTitle("Comment: " + reply);
            NotificationManager notificationManager = (NotificationManager) context.
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());

            context.startActivity(intent);

        }


        //if disaprove button is clicked
        if (intent.getIntExtra(NotificationKeyStore.KEY_INTENT_DISAPPROVE, -1) == NotificationKeyStore.REQUEST_CODE_DISAPPROVE) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context,
                    NotificationKeyStore.REQUEST_CODE_DISAPPROVE,
                    new Intent(context, NotificationBroadcastReceiver.class)
                            .putExtra(NotificationKeyStore.KEY_INTENT_DISAPPROVE, NotificationKeyStore.REQUEST_CODE_DISAPPROVE),
                    PendingIntent.FLAG_UPDATE_CURRENT
            );

            NotificationCompat.Action action = setAction(pendingIntent);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NotificationKeyStore.CHANNNEL_ID)
                    .setSmallIcon(R.drawable.app_icon_white)
                    .setContentTitle("Lead Disapproved")
                    .setContentText("Would you like to add a comment?")
                    .setColor(context.getResources().getColor(R.color.theme_color))
                    .addAction(action);

            NotificationManager notificationManager = (NotificationManager) context.
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());


            Toast.makeText(context, "Lead has been Dissaproved", Toast.LENGTH_LONG).show();
        }

        //if approve button is clicked
        if (intent.getIntExtra(NotificationKeyStore.KEY_INTENT_APPROVE, -1) == NotificationKeyStore.REQUEST_CODE_APPROVE) {

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context,
                    NotificationKeyStore.REQUEST_CODE_APPROVE,
                    new Intent(context, NotificationBroadcastReceiver.class)
                            .putExtra(NotificationKeyStore.KEY_INTENT_APPROVE, NotificationKeyStore.REQUEST_CODE_APPROVE),
                    PendingIntent.FLAG_UPDATE_CURRENT
            );

            NotificationCompat.Action action = setAction(pendingIntent);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NotificationKeyStore.CHANNNEL_ID)
                    .setSmallIcon(R.drawable.app_icon_white)
                    .setContentTitle("Lead has been Approved")
                    .setContentText("Would you like to add a comment?")
                    .setColor(context.getResources().getColor(R.color.theme_color))
                    .addAction(action);

            NotificationManager notificationManager = (NotificationManager) context.
                    getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NotificationKeyStore.NOTIFICATION_ID, mBuilder.build());


            Toast.makeText(context, "Lead Approved", Toast.LENGTH_LONG).show();
        }
    }

    public NotificationCompat.Action setAction(PendingIntent pendingIntent) {
        RemoteInput remoteInput = new RemoteInput.Builder(NotificationKeyStore.NOTIFICATION_REPLY)
                .setLabel("Comment...")
                .build();

        //For the remote input we need this action object
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.ic_done_white_24dp,
                        "Add A Comment", pendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();
        return action;
    }

}