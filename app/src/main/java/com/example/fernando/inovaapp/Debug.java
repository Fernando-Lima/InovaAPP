package com.example.fernando.inovaapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Debug extends AppCompatActivity {
    protected static final String TAG = "ciclo";

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG,getLocalClassName()+".onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,getLocalClassName()+".onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,getLocalClassName()+".onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,getLocalClassName()+".onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,getLocalClassName()+".onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,getLocalClassName()+".onDestroy");
    }
}
