package com.example.myapplication.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UrlInterface {
    @GET("/android?method=TASKSUBMISSION")
    Call<String> submit_call_task(@Query("call_details") String call_details);
}
