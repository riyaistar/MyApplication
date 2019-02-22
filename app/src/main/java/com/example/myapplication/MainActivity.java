package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.myapplication.utility.CustomSpinnerAdapter;
import com.example.myapplication.utility.LocationTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] PERMISSIONS = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_FINE_LOCATION};
    private static final int PERMISSION_REQUEST_CODE = 200;
    private String[] countries = new String[]{"India","Iran","Iraq","Irak","Iraj","Irap","Iraq","Ira1w","Iradf","Irasaa","Irasa","Iraasda","Irag","France","Italy","England"};
    private String[] countries1 = new String[]{"Poland","Pasjj","France","Italy","England"};
    CustomSpinnerAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermissions())
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);
        Button btn1 = (Button) findViewById(R.id.button);

        Button btn = (Button) findViewById(R.id.btn);
        final AutoCompleteTextView location = (AutoCompleteTextView) findViewById(R.id.location);
        dataAdapter = new CustomSpinnerAdapter(MainActivity.this, R.layout.customspinner, Arrays.asList(countries));
        location.setAdapter(dataAdapter);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataAdapter = new CustomSpinnerAdapter(MainActivity.this, R.layout.customspinner, Arrays.asList(countries1));
                location.setAdapter(dataAdapter);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LocationTrack locationTrack = new LocationTrack(MainActivity.this);


                if (locationTrack.canGetLocation()) {


                    double longitude = locationTrack.getLongitude();
                    double latitude = locationTrack.getLatitude();

                    //location.setText("Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude));
                } else {

                    locationTrack.showSettingsAlert();
                }

            }
        });

    }




    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : PERMISSIONS) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(), p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;
    }
}
