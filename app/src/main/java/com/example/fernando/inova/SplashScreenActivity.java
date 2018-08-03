package com.example.fernando.inova;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Debug {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showLogin();
            }
        },1000);
    }

    public void showLogin(){
        Intent it = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(it);
        finish();
    }

    public void showMain(){
        Intent it = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
