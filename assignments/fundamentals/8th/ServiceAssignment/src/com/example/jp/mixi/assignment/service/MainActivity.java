package com.example.jp.mixi.assignment.service;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences sp = getSharedPreferences("service", MODE_PRIVATE);
        Integer count = sp.getInt("count", 0);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(count.toString());
        
        Button startIntentService = (Button) findViewById(R.id.IntentServiceButton);
        startIntentService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.text);
                String count = textView.getText().toString();
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("count", count);
                startService(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
