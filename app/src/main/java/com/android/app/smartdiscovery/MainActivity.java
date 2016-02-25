package com.android.app.smartdiscovery;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

//AppId: 550979021727514
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences =
                getSharedPreferences("SmartDiscovery", MODE_PRIVATE);
        final Boolean loginStatus = sharedPreferences.getBoolean("LoginStatus", false);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // If the user didn't logged in yet, then redirect the user to the login activity. Otherwise redirect the user to the home page activity
                if (!loginStatus) {
                    //create an intent and pass it to the login activity
                    Log.e("MainActivity--", "Check here");
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //create an intent and pass it to the home_page activity
                    Log.e("MainActivity", "Check here too");
                }
            }
        }, 5000);

    }
}
