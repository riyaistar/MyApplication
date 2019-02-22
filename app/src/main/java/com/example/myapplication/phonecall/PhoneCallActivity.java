package com.example.myapplication.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneCallActivity extends AppCompatActivity{
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0 ;
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
                    Log.d("permission","not granted permission");
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
    public void openmaps(){
        startActivity(new Intent(PhoneCallActivity.this,MapsActivity.class));
        finish();
    }
    @OnClick(R.id.video)
    public void openvideo(){
        startActivity(new Intent(PhoneCallActivity.this,PIPActivity.class));
        finish();
    }
}
