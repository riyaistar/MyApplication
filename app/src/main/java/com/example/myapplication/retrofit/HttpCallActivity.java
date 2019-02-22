package com.example.myapplication.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpCallActivity extends AppCompatActivity {
    private static final String TAG = "HttpCallActivity";
    private UrlInterface urlInterface;
    private TaskSubmission taskSubmission = new TaskSubmission();
    public Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_call);

        Button button = (Button) findViewById(R.id.button2);
        taskSubmission.setActor(123);
        taskSubmission.setCall_notes("Tesstt");
        taskSubmission.setCall_rating((float) 3.5);


        urlInterface = RestApiClient.getClient(this).create(UrlInterface.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }


    public void makeCall(){
        Call<String> makeCall = urlInterface.submit_call_task(gson.toJson(taskSubmission));
        makeCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG,"on response"+response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG,"on Failure");
            }
        });
    }


}
