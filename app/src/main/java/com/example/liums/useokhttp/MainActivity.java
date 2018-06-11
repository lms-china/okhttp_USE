package com.example.liums.useokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();
    }

    private void request() {
    new Thread(new Runnable() {
        @Override
        public void run() { 


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://www.baidu.com/")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Log.i("DebugOkHttp", response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();

    }
}
