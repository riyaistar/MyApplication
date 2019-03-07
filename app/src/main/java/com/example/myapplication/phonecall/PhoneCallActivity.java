package com.example.myapplication.phonecall;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.notif.NotificationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneCallActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    @BindView(R.id.call_button)
    Button button;
    @BindView(R.id.openmaps)
    Button openmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        ButterKnife.bind(this);
        requestPermission();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:08657601666"));
                if (ActivityCompat.checkSelfPermission(PhoneCallActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Log.d("permission", "not granted permission");
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @OnClick(R.id.openmaps)
    public void openmaps() {
        startActivity(new Intent(PhoneCallActivity.this, MapsActivity.class));
        finish();
    }

    @OnClick(R.id.video)
    public void openvideo() {
        startActivity(new Intent(PhoneCallActivity.this, PIPActivity.class));
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.expandable)
    public void withItems(View view) {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        final View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert2, viewGroup, false);
        final TextView message = dialogView.findViewById(R.id.message);
        message.setText(getResources().getString(R.string.message));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button okbutton = dialogView.findViewById(R.id.buttonok);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        Button cancel = dialogView.findViewById(R.id.buttoncancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }


    @OnClick(R.id.notification)
    public void opennotification() {
        startActivity(new Intent(PhoneCallActivity.this, NotificationActivity.class));
        finish();
    }
}

