package com.example.myapplication.notif;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.notifButton)
    public void sendNotification(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
                mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        mBuilder.setContentTitle("Notification Alert, Click Me!");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");

    }
}
