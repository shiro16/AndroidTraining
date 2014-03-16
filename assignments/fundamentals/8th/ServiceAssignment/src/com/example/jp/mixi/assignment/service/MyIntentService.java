package com.example.jp.mixi.assignment.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        this(MyIntentService.class.getSimpleName());
    }
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Integer count = Integer.parseInt(intent.getStringExtra("count"));
        SharedPreferences sp = getSharedPreferences("service", MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putInt("count", ++count);
        editor.commit();
    }

    
}
